package com.revature.daos;

import java.util.List;

import com.revature.models.AnimePlush;

public interface PlushDAO {
	AnimePlush createPlush(AnimePlush p);
	List<AnimePlush> retrieveTasks();
	AnimePlush retrievePlushById(int id);
	List<AnimePlush> retrievePlushByUserId(int id);
	boolean updatePlush(AnimePlush p);
}
