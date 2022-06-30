package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.revature.models.AnimePlush;
import com.revature.models.Transaction;
import com.revature.util.ConnectionUtil;

public class PaymentHistoryPostgres implements PaymentHistoryDAO {

	@Override
	public Transaction addPaymentRecord(Transaction t) {
		// TODO Auto-generated method stub
		String sql = "insert into payment_history(user_id, item_id, pay_date, balance_remaining, emp_authed, payamount) "
				+ "values(?,?,?,?,?,?)";
		
		try(Connection c = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, t.getUser_id());
			ps.setInt(2, t.getItem_id());
			ps.setDate(3, Date.valueOf(LocalDate.now()));
			ps.setInt(4, t.getBalance());
			ps.setInt(5, t.getEmp_authed());
			ps.setInt(6, t.getPayAmount());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Transaction> retrievePaymentHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnimePlush retrievePaymentsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> retrievePlushByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Transaction t) {
		// TODO Auto-generated method stub
		return false;
	}

}
