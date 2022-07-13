package com.revature.dtos;

import java.awt.Image;
import java.time.LocalTime;
import java.util.Date;

import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.RequestType;
import com.revature.models.User;

public class RequestDTO {
	private int requestId;
	private float ammount;
	private Date dateSubmitted;
	private String desc;
	private User author;
	private RequestStatus status;
	private RequestType type;
	
	public RequestDTO(Request r) {
		this.requestId = r.getRequestId();
		this.ammount = r.getAmmount();
		this.desc = r.getDesc();
		this.author = r.getAuthor();
	}

	public RequestDTO(int requestId, float ammount, Date dateSubmitted, String desc, User author,
			RequestStatus status, RequestType type) {
		super();
		this.requestId = requestId;
		this.ammount = ammount;
		this.dateSubmitted = dateSubmitted;
		this.desc = desc;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	
	// To String
	@Override
	public String toString() {
		return "RequestDTO [requestId=" + requestId + ", ammount=" + ammount + ", dateSubmitted=" + dateSubmitted
				+ ", desc=" + desc + ", author=" + author + ", status=" + status + ", type=" + type + "]";
	}

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


	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}


	public Date getDateSubmitted() {
		return dateSubmitted;
	}


	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public User getAuthor() {
		return author;
	}


	public void setAuthor(User author) {
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
}
