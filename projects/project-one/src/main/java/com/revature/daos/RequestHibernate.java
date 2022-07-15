package com.revature.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class RequestHibernate implements RequestDAO {
	private static Logger log = LogManager.getLogger(RequestHibernate.class);
	
	@Override
	public Request createOffer(Request r) {
		// TODO Auto-generated method stub
		r.setRequestId(-1);
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			r.setStatus(RequestStatus.PENDING);
			int id = (int) s.save(r);
			r.setRequestId(id);
			tx.commit();
			
			log.info("REQUEST CREATED " + r.toString());
		} catch (ConstraintViolationException e) {
			// log it
			log.error(e);
		}
		return r;

	}

	@Override
	public List<Request> retrieveRequests(String mode, User principal) {
		// TODO Auto-generated method stub
		List<Request> requests = null;
		switch (mode) {
		case "PENDING_BY_ID":
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Request> cq = cb.createQuery(Request.class);

				Root<Request> root = cq.from(Request.class);

				Predicate predicateForStatus = cb.equal(root.get("status").as(String.class),
						RequestStatus.PENDING.toString());
				Predicate predicateForId = cb.equal(root.get("author"), principal);
				cq.select(root).where(predicateForStatus, predicateForId);

				requests = (List<Request>) s.createQuery(cq).getResultList();
			}
			break;
		case "ACCEPTED_BY_ID":
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Request> cq = cb.createQuery(Request.class);

				Root<Request> root = cq.from(Request.class);

				Predicate predicateForStatus = cb.equal(root.get("status").as(String.class),
						RequestStatus.ACCEPTED.toString());
				Predicate predicateForId = cb.equal(root.get("author"), principal);
				cq.select(root).where(predicateForStatus, predicateForId);

				requests = (List<Request>) s.createQuery(cq).getResultList();
			}
			break;
		case "DENIED_BY_ID":
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Request> cq = cb.createQuery(Request.class);

				Root<Request> root = cq.from(Request.class);

				Predicate predicateForStatus = cb.equal(root.get("status").as(String.class),
						RequestStatus.DENIED.toString());
				Predicate predicateForId = cb.equal(root.get("author"), principal);
				cq.select(root).where(predicateForStatus, predicateForId);

				requests = (List<Request>) s.createQuery(cq).getResultList();
			}
			break;
		case "ALL_PENDING":
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Request> cq = cb.createQuery(Request.class);

				Root<Request> root = cq.from(Request.class);

				Predicate predicateForStatus = cb.equal(root.get("status").as(String.class),
						RequestStatus.PENDING.toString());
				cq.select(root).where(predicateForStatus);

				requests = (List<Request>) s.createQuery(cq).getResultList();
			}
			break;
		case "ALL":
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {

				requests = s.createQuery("from Request", Request.class).list();
			}
			break;
		case "ALL_USER_INFO": 
			try (Session s = HibernateUtil.getSessionFactory().openSession()) {
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<Request> cq = cb.createQuery(Request.class);

				Root<Request> root = cq.from(Request.class);

				Predicate predicateForId = cb.equal(root.get("author"), principal);
				cq.select(root).where(predicateForId);

				requests = (List<Request>) s.createQuery(cq).getResultList();
			}
			break;
		}
		return requests;

	}

	@Override
	public Request retrieveRequestsById(int id) {
		// TODO Auto-generated method stub
		Request r = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			// SELECT * FROM USERS WHERE USERNAME = '';
			r = s.get(Request.class, id);
		}

		return r;
	}

	@Override
	public List<Request> retrieveRequestsByItemId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRequest(Request r) {
		// TODO Auto-generated method stub
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction tx = s.beginTransaction();
			Request r2 = s.load(Request.class, r.getRequestId());
			
			r2.setStatus(r.getStatus());
			r2.setDateResolved(new Date());
			r2.setCaseManager(r.getCaseManager());
			s.update(r2);
			System.out.println("Chilling in update");
			
			tx.commit();
			log.info("REQUEST UPDATED from " + r.toString() + " to " + r2.toString());
		}
		return false;
	}

}
