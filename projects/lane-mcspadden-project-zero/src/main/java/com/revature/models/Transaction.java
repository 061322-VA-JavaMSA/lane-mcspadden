package com.revature.models;

import java.sql.Date;
import java.util.Objects;

public class Transaction {
	private int user_id;
	private int item_id;
	private Date pay_date;
	private int payAmount;
	private int balance;
	private int emp_authed;
	
	public Transaction() {
		
	}
	
	public Transaction(int user_id, int item_id, Date pay_date, int balance, int payAmount, int emp_authed) {
		this.user_id = user_id;
		this.item_id = item_id;
		this.pay_date = pay_date;
		this.balance = balance;
		this.payAmount = payAmount;
		this.emp_authed = emp_authed;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getEmp_authed() {
		return emp_authed;
	}

	public void setEmp_authed(int emp_authed) {
		this.emp_authed = emp_authed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, emp_authed, item_id, pay_date, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return balance == other.balance && emp_authed == other.emp_authed && item_id == other.item_id
				&& Objects.equals(pay_date, other.pay_date) && user_id == other.user_id;
	}

	public int getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	
	
}
