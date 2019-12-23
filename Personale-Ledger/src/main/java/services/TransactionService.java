package services;

import java.util.List;

import entities.Transaction;

public interface TransactionService {
    public List<Transaction> SelTutti();
    public Transaction SelById(String id);
    public void InsTransaction(Transaction transaction);
    public void DelTransaction(Transaction transaction);
}
