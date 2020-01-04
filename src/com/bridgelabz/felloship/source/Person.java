package com.bridgelabz.felloship.source;

import java.util.List;

import com.google.gson.Gson;

public class Person {

	String FirstName;
	String LastName;
	String Address;
	String State;
	String City;
	String zipcode;
	String phone;


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

/*
	public Person(String firstName, String lastName, String address, String state, String city, String zipcode,
			String phone) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		State = state;
		City = city;
		this.zipcode = zipcode;
		this.phone = phone;
	}
*/
}
