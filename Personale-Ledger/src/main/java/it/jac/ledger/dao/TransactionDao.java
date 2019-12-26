package it.jac.ledger.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.util.HibernateUtil;

@Component
public class TransactionDao {

	// Armando: i metodi in Java iniziano con il carattere minuscolo
	// es. insTransaction..
	
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

//		public float getBilancioByUsername(String username) {
//			try (Session session = HibernateUtil.getSessionFactory().openSession()){
//				Query<Float> query= session.createQuery("select sum(valore) from Transactions where username = '" + username + "'", Float.class);
//				return query.getSingleResult();
//			}
//		}

	public TransactionBean findById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.get(TransactionBean.class, id);
		}
	}

	public List<TransactionBean> findAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// armando: il nome riportato dopo il FROM fa riferimento all'entità
			Query<TransactionBean> query = session.createQuery("FROM TransactionBean", TransactionBean.class);
			return query.list();
		}
	}
}
