package com.revature.services;

import java.util.List;

import com.revature.daos.RequestDAO;
import com.revature.daos.RequestHibernate;
import com.revature.exceptions.CouldNotCreateRequestException;
import com.revature.exceptions.NoNewRequestsException;
import com.revature.models.Request;

public class TixService {
	private RequestDAO rd = new RequestHibernate();
	
	public List<Request> generatePending() throws NoNewRequestsException {
		List<Request> requests = rd.retrieveRequests();
		
		if(requests == null) {
			throw new NoNewRequestsException();
		}
		
		return requests;
		
	}
	
	public Request createRequest(Request r) throws CouldNotCreateRequestException {
		Request request = rd.createOffer(r);
		
		if(request == null) {
			throw new CouldNotCreateRequestException();
		}
		
		return request;
	}
}
