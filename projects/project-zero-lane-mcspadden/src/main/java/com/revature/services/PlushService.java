package com.revature.services;

import java.util.List;

import com.revature.daos.PlushDAO;
import com.revature.daos.PlushPostgres;
import com.revature.models.AnimePlush;

public class PlushService {
	private PlushDAO pd = new PlushPostgres();
	
	public List<AnimePlush> getPlushesByUserId(int id){
		//
		return pd.retrievePlushByUserId(id);
	}
}
