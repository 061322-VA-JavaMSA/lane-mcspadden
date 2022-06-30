package com.revature.models;

import java.util.Objects;

public class Offer {
	
	int offer_id;
	int item_id;
	int user_id;
	int offer;
	OfferStatus status;

	public OfferStatus getStatus() {
		return status;
	}

	public void setStatus(OfferStatus status) {
		this.status = status;
	}

	public Offer() {

	}

	@Override
	public String toString() {
		return "Offer [item_id=" + item_id + ", user_id=" + user_id + ", item_name=" + ", offer=" + offer
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, offer, user_id);
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
		return item_id == other.item_id && offer == other.offer
				&& user_id == other.user_id;
	}
	
	public int getOffer_id() {
		return offer_id;
	}

	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
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

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}
}
