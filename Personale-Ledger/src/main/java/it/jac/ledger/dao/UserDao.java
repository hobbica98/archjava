package it.jac.ledger.dao;

import java.util.List;

import org.hibernate.query.Query;

import it.jac.ledger.entities.UserBean;
import it.jac.ledger.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
	public void InsUser(UserBean user) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			
			session.persist(user);
			
			tx.commit();
		}
	}
	
	public void DelUser(UserBean user) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		
			Transaction tx = session.beginTransaction();
			
			session.delete(user);
			
			tx.commit();
		}
	}

	public UserBean findByUsername(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(UserBean.class, username);
		}
	}

	public List<UserBean> findAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			return session.createQuery("FROM Users", UserBean.class).getResultList();
		}
	}
}
