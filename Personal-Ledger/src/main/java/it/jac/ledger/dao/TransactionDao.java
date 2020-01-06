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
	
	public void insTransaction(TransactionBean trans) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.persist(trans);

			tx.commit();
		}
	}

	public void delTransaction(TransactionBean trans) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(trans);

			tx.commit();
		}
	}
	
	// estrae il bilancio attuale per un username
	public double getBilancioByUsername(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Query<Double> query= session.createQuery("select sum(valore) from TransactionBean where username = '" + username + "'", Double.class);	
			return query.getSingleResult();
		}
	}
	
	// estrae la media delle transazioni deposito per un username
	public double getAvgDeposit(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Query<Double> query= session.createQuery("select avg(valore) from Transactions where username = '" + username + "' and valore > 0", Double.class);
			return query.getSingleResult();
		}
	}
	
	// estrae la media delle transazioni prelievo per un username
	public double getAvgWithdrawal(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Query<Double> query= session.createQuery("select avg(valore) from Transactions where username = '" + username + "' and valore < 0", Double.class);
			return query.getSingleResult();
		}
	}

	public TransactionBean findById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			return session.get(TransactionBean.class, id);
		}
	}

	public List<TransactionBean> findAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// il nome riportato dopo il FROM fa riferimento all'entità
			Query<TransactionBean> query = session.createQuery("FROM TransactionBean", TransactionBean.class);
			return query.list();
		}
	}
	
	public List<TransactionBean> findByUsername(String username) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// il nome riportato dopo il FROM fa riferimento all'entità
			Query<TransactionBean> query = session.createQuery("FROM TransactionBean where username='" + username + "'", TransactionBean.class);
			return query.list();
		}
	}
}
