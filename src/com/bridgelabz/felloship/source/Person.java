package com.bridgelabz.felloship.source;

import java.util.List;

import com.google.gson.Gson;

@SuppressWarnings({ "unused" })
public class Person {

	String FirstName;
	String LastName;
	String Address;
	String State;
	String City;
	String zipcode;
	String phone;


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

}
