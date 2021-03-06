// #######################################################################################
// #####                   CLASS NAME: AnimePlush
// #####	  Author: Lane McSpadden
// #####	  Company: Revature
// #####      DESCRIPTION: Model class for the anime plush objects used in the store
// #######################################################################################

package com.revature.models;

public class AnimePlush {
	//Private variables
	private int id;
	private String name;
	private String description;
	private int price;
	private AnimePlushStatus status;
	
	
	
	public AnimePlush() {
//		this.id = null;
		this.name = null;
		this.description = null;
		this.status = null;
	}
	
	
	public AnimePlush(String name, String description, AnimePlushStatus status) {
		this.name = name;
		this.description = description;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public AnimePlushStatus getStatus() {
		return status;
	}


	public void setStatus(AnimePlushStatus status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimePlush other = (AnimePlush) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "AnimePlush [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + "]";
	}


	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}


	public void setPrice(int price) {
		// TODO Auto-generated method stub
		this.price = price;
	}


	public void setStatus(String string) {
		// TODO Auto-generated method stub
		this.status = AnimePlushStatus.valueOf(string);
	}
	
	
	
	
}
