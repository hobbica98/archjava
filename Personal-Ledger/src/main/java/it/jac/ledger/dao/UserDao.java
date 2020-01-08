package it.jac.ledger.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.jac.ledger.entities.UserBean;
import it.jac.ledger.util.HibernateUtil;

public class UserDao {
	
	public void insUser(UserBean user) throws PersistenceException{
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			
			session.persist(user);
			
			tx.commit();
		}
	}
	
	public void delUser(UserBean user) {
		
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
