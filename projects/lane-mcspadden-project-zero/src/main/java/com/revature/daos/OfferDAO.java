package com.revature.daos;

import java.util.List;

import com.revature.models.Offer;
import com.revature.models.AnimePlush;

public interface OfferDAO {
	Offer createOffer(Offer o);
	List<Offer> retrieveOffers();
	Offer retrieveOffersById(int id);
	List<Offer> retrieveOffersByItemId(int id);
	boolean updateOffer(Offer o);
}
