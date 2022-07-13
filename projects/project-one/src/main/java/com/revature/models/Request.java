package com.revature.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "requests")
public class Request {

	// Private Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id", nullable = false, unique = true)
	private int requestId;
	@Column(name = "ammount")
	private int ammount;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_sub")
	private Date dateSubmitted;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_res")
	private Date dateResolved;
	@Column(name = "reqdesc")
	private String desc;
	@Column(name = "receipt")
	private String receipt;
	@ManyToOne
	@JoinColumn(name = "author_id")
	private User author;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private RequestStatus status;
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private RequestType type;

	// Getters and Setters

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

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

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
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

	// To String

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", ammount=" + ammount + ", dateSubmitted=" + dateSubmitted
				+ ", dateResolved=" + dateResolved + ", desc=" + desc + ", receipt=" + receipt + ", author=" + author
				+ ", status=" + status + ", type=" + type + "]";
	}

	// HashCode and .equals

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
