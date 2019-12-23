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

	@Override
	public void InsUser(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DelUser(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}
	

}
