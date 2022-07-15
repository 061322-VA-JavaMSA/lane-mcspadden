package com.revature.daos;

import java.util.List;

import com.revature.models.Request;
import com.revature.models.User;

public interface RequestDAO {
	Request createOffer(Request r);
	List<Request> retrieveRequests(String mode, User principal);
	Request retrieveRequestsById(int id);
	List<Request> retrieveRequestsByItemId(int id);
	boolean updateRequest(Request r);
}
