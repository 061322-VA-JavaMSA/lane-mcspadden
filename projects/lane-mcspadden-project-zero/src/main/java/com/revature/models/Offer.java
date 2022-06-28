package com.revature.models;

import java.util.Objects;

public class Offer {
	int item_id;
	int user_id;
	String item_name;
	int offer;
	
	Offer() {
		
	}

	@Override
	public String toString() {
		return "Offer [item_id=" + item_id + ", user_id=" + user_id + ", item_name=" + item_name + ", offer=" + offer
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, item_name, offer, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return item_id == other.item_id && Objects.equals(item_name, other.item_name) && offer == other.offer
				&& user_id == other.user_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}
}
