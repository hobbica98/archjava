package it.jac.ledger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.jac.ledger.dao.TransactionDao;
import it.jac.ledger.entities.TransactionBean;

@Component
public class TransactionService{

	// come nel controller gestisco la dipendenza con l'annotazione
	// non serve fare la new della classe, ci pensa Spring
	@Autowired
	private TransactionDao transDao;
	
	public List<TransactionBean> SelTutti() {
		return this.transDao.findAll();
	}

	public TransactionBean SelById(int id) {
		// TODO Auto-generated method stub
		return this.transDao.findById(id);
	}
	
	public void InsTransaction(TransactionBean trans) {
		this.transDao.InsTransaction(trans);
		
	}
	
	public void DelTransaction(TransactionBean trans) {
		this.transDao.DelTransaction(trans);
		
	}
	
	/*
	public float getBilancioByUsername(String username) {
		return this.transDao.getBilancioByUsername(username);
	}
	*/
}
