package com.revature.daos;

import java.util.List;

import com.revature.models.Offer;
import com.revature.models.AnimePlush;

public interface OfferDAO {
	Offer createOffer(Offer o);
	List<Offer> retrieveOffers();
	Offer retrievePlushById(int id);
	List<Offer> retrievePlushByUserId(int id);
	boolean updatePlush(Offer o);
}
