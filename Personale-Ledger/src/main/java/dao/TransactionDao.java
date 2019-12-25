package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.TransactionBean;
import util.HibernateUtil;

public class TransactionDao {

	public void InsTransaction(TransactionBean trans) {
			
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				Transaction tx = session.beginTransaction();
				
				session.persist(trans);
				
				tx.commit();
			}
		}
		
		public void DelTransaction(TransactionBean trans) {
			
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				Transaction tx = session.beginTransaction();
				
				session.delete(trans);
				
				tx.commit();
			}
		}
		/*
		public float getBilancioByUsername(String username) {
			try (Session session = HibernateUtil.getSessionFactory().openSession()){
				Query<Float> query= session.createQuery("select sum(valore) from Transactions where username = '" + username + "'", Float.class);
				return query.getSingleResult();
			}
		}
		*/
		
		public TransactionBean findById(int id) {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				
				return session.get(TransactionBean.class, id);
			}
		}
	
		public List<TransactionBean> findAll() {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				Query<TransactionBean> query= session.createQuery("SELECT TRANSACTIONS FROM TRANSACTIONS", TransactionBean.class);
				return query.list();
			}
		}
}
