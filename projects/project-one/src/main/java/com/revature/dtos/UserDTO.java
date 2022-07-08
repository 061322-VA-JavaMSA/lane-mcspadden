package com.revature.dtos;

import java.util.Objects;

import com.revature.models.User;
import com.revature.models.UserTitle;

public class UserDTO {

	private int id;
	private String username;
	private UserTitle title;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User u) {
		id = u.getId();
		username = u.getUsername();
		title = u.getUserTitle();
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserTitle getTitle() {
		return title;
	}

	public void setTitle(UserTitle title) {
		this.title = title;
	}
	
	//To String

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", title=" + title + "]";
	}

	//HashCode and .Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(id, title, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return id == other.id && title == other.title && Objects.equals(username, other.username);
	}
	
}
