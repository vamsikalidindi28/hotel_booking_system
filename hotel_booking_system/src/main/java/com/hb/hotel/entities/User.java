package com.hb.hotel.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	private int age;

	private char gender;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Room.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "uid", referencedColumnName = "user_id")
	private Set<Room> room;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public void setRoom(Set<Room> room) {
		this.room = room;
	}

	public Set<Room> getRoom() {
		return room;
	}

}
