package com.bridgelabz.fellowship.model;

public class Person {

	public String FirstName;
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

	@Override
	public String toString() {
		return "FirstName=" + FirstName + "\nLastName=" + LastName + "\nAddress=" + Address + "\nState=" + State
				+ "\nCity=" + City + "\nzipcode=" + zipcode + "\nphone=" + phone;
	}

}
