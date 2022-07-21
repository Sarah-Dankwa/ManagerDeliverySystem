package com.qa.domain;

public class Driver {

private int driverID;
private String firstName;
private String surname;

public Driver(int driverID, String firstName, String surname) {
	this.driverID = driverID;
	this.firstName = firstName;
	this.surname = surname;
}

public Driver(String firstName, String surname) {
	this.firstName = firstName;
	this.surname = surname;
}


@Override
public String toString() {
	return "Driver [driverID=" + driverID + ", firstName=" + firstName + ", surname=" + surname + "]";
}


public int getDriverID() {
	return driverID;
}



public void setDriverID(int driverID) {
	this.driverID = driverID;
}



public String getFirstName() {
	return firstName;
}



public void setFirstName(String firstName) {
	this.firstName = firstName;
}



public String getSurname() {
	return surname;
}



public void setSurname(String surname) {
	this.surname = surname;
}

	
}
