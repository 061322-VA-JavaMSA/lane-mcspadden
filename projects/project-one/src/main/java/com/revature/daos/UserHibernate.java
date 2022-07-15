package com.revature.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Request;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserHibernate implements UserDAO {

	@Override
	public User createUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User retrieveUserById(int id) {
		// TODO Auto-generated method stub
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			
			Root<User> root = cq.from(User.class);
			
			Predicate predicateForUsername = cb.equal(root.get("id"), id);			
			cq.select(root).where(predicateForUsername);
			

			user = (User) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<User> retrieveUsers() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
		users = s.createQuery("from User", User.class).list();
		}
		return users;
	}

	@Override
	public User getUserByUsername(String username) {
		User user = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession();){
			// SELECT * FROM USERS WHERE USERNAME = '';
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			
			Root<User> root = cq.from(User.class);
			
			Predicate predicateForUsername = cb.equal(root.get("username"), username);			
			cq.select(root).where(predicateForUsername);
			

			user = (User) s.createQuery(cq).getSingleResult();
		}
		
		return user;
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			Transaction tx = s.beginTransaction();
			User u2 = s.load(User.class, u.getId());
			u2.setEmail(u.getEmail());
			u2.setPassword(u.getPassword());
			u2.setUsername(u.getUsername());
			s.update(u2);
			System.out.println("Chilling in update");
			tx.commit();
		}
		return false;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
