package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Transaction;
import repository.TransactionRepo;

public class TransactionServiceImpl implements TransactionService{
	@Autowired
    public TransactionRepo transRepo;

    public TransactionServiceImpl(TransactionRepo transRepo) {
        this.transRepo = transRepo;
    }
	@Override
	public List<Transaction> SelTutti() {
		return this.transRepo.findAll();
	}

	@Override
	public Transaction SelById(String id) {
		// TODO Auto-generated method stub
		return this.transRepo.findById(id);
	}
	
    //INSERT
	@Override
	public void InsTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	//DELETE
	@Override
	public void DelTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}
	

}
