package com.revature.daos;

import java.util.List;

import com.revature.models.AnimePlush;
import com.revature.models.Transaction;

public interface PaymentHistoryDAO {
	Transaction addPaymentRecord(Transaction t);
	List<Transaction> retrievePaymentHistory();
	AnimePlush retrievePaymentsByUsername(String username);
	List<Transaction> retrievePlushByUserId(int id);
	boolean update(Transaction t);
}
