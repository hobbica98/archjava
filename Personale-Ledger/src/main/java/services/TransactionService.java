package services;

import java.util.List;

import dao.TransactionDao;
import entities.TransactionBean;

public class TransactionService{

	TransactionDao transDao = new TransactionDao();
	
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
	

}
