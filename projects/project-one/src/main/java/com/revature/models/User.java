package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	//Private Data Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", nullable = false, unique = true)
	private int id;
	@Column(name="username", nullable = false, unique = true)
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="fname")
	private String firstName;
	@Column(name="lname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Enumerated(EnumType.STRING)
	@Column(name="title")
	private UserTitle userTitle;
	
	//Setters and Getters
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public UserTitle getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(UserTitle userTitle) {
		this.userTitle = userTitle;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	//To String
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userTitle=" + userTitle + "]";
	}
	
	
	//Hash and .Equals
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, password, userTitle, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && userTitle == other.userTitle
				&& Objects.equals(username, other.username);
	}

	
	

	

	
	
	
}
