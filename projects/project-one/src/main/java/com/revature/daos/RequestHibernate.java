package com.revature.daos;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.util.HibernateUtil;

public class RequestHibernate implements RequestDAO {

	@Override
	public Request createOffer(Request r) {
		// TODO Auto-generated method stub
		r.setRequestId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			r.setStatus(RequestStatus.PENDING);
			int id = (int) s.save(r);
			r.setRequestId(id);
			tx.commit();	
		} catch(ConstraintViolationException e) {
			//log it
		}
		return r;

	}

	@Override
	public List<Request> retrieveRequests() {
		// TODO Auto-generated method stub
		List<Request> requests = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Request> cq = cb.createQuery(Request.class);
			
			Root<Request> root = cq.from(Request.class);
			
			
			Predicate predicateForStatus = cb.equal(root.get("status").as(String.class), RequestStatus.PENDING.toString());
			cq.select(root).where(predicateForStatus);
			
			requests = (List<Request>) s.createQuery(cq).getResultList();
		}
		return requests;
	}

	@Override
	public Request retrieveRequestsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Request> retrieveRequestsByItemId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequest(Request o) {
		// TODO Auto-generated method stub
		return false;
	}

}
