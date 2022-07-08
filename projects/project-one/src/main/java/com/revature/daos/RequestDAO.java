package com.revature.daos;

import java.util.List;

import com.revature.models.Request;

public interface RequestDAO {
	Request createOffer(Request r);
	List<Request> retrieveRequests();
	Request retrieveRequestsById(int id);
	List<Request> retrieveRequestsByItemId(int id);
	boolean updateRequest(Request o);
}
