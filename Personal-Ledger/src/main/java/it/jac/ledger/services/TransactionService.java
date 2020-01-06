package it.jac.ledger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.jac.ledger.dao.TransactionDao;
import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.entities.UserBean;

@Component
public class TransactionService{

	// come nel controller gestisco la dipendenza con l'annotazione
	// non serve fare la new della classe, ci pensa Spring
	@Autowired
	private TransactionDao transDao;
	
	public List<TransactionBean> selTutti() {
		return this.transDao.findAll();
	}

	public TransactionBean selById(int id) {
		return this.transDao.findById(id);
	}
	
	public void insTransaction(TransactionBean trans) {
		this.transDao.insTransaction(trans);
		
	}
	
	public void delTransaction(TransactionBean trans) {
		this.transDao.delTransaction(trans);
		
	}
	
	public void delTransaction(int id) {
		TransactionBean trans= new TransactionBean();
		trans.setId(id);
		this.transDao.delTransaction(trans);
		
	}
	public double getBilancioByUsername(String username) {
		return this.transDao.getBilancioByUsername(username);
	}
	
	public List<TransactionBean> selByUsername(String username){
		return this.transDao.findByUsername(username);
	}

	public void save(TransactionBean trans) {
		this.transDao.save(trans);
		
	}
	
}
