package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.TransactionBean;
import repository.TransactionRepo;

public class TransactionService{

    public TransactionService() {
    }
	public List<TransactionBean> SelTutti() {
		return this.transRepo.findAll();
	}

	public TransactionBean SelById(String id) {
		// TODO Auto-generated method stub
		return this.transRepo.findById(id);
	}
	
	public void InsTransaction(TransactionBean transaction) {
		// TODO Auto-generated method stub
		
	}
	
	public void DelTransaction(TransactionBean transaction) {
		// TODO Auto-generated method stub
		
	}
	

}
