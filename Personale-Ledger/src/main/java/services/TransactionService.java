package services;

import java.util.List;

import entities.Transaction;

public interface TransactionService {
    public List<Transaction> SelTutti();
    public Transaction SelById(String id);
    public void InsUser(Transaction transaction);
    public void DelUser(Transaction transaction);
}
