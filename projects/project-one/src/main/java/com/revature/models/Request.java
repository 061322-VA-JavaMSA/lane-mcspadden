package com.revature.models;

import java.awt.Image;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class Request {
	
	//Private Variables
	
	private int requestId;
	private float ammount;
	private LocalTime dateSubmitted;
	private LocalTime dateResolved;
	private String desc;
	private Image[] receipt;
	private int author;
	private RequestStatus status;
	private RequestType type;
	
	//Getters and Setters
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public float getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	public LocalTime getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(LocalTime dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public LocalTime getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(LocalTime dateResolved) {
		this.dateResolved = dateResolved;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Image[] getReceipt() {
		return receipt;
	}
	public void setReceipt(Image[] receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public RequestStatus getStatus() {
		return status;
	}
	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	public RequestType getType() {
		return type;
	}
	public void setType(RequestType type) {
		this.type = type;
	}
	
	//To String
	
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", ammount=" + ammount + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", desc=" + desc + ", receipt=" + Arrays.toString(receipt)
				+ ", author=" + author + ", status=" + status + ", type=" + type + "]";
	}

	//HashCode and .equals
	
	@Override
	public int hashCode() {
		return Objects.hash(ammount, author, dateResolved, dateSubmitted, desc, requestId, status, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Float.floatToIntBits(ammount) == Float.floatToIntBits(other.ammount) && author == other.author
				&& Objects.equals(dateResolved, other.dateResolved)
				&& Objects.equals(dateSubmitted, other.dateSubmitted) && Objects.equals(desc, other.desc)
				&& requestId == other.requestId && status == other.status && type == other.type;
	}

	
	
}
