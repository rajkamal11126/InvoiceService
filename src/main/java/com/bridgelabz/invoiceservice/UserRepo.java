package com.bridgelabz.invoiceservice;

import java.util.ArrayList;

public class UserRepo {
	String userid;
	private ArrayList<Ride> rideList;

	//initializes a user id and a rideList that will be used to store multiple rides for the user id
	public UserRepo(String userid ) { 
        this.userid = userid;
        this.rideList = new ArrayList<>();
    }

	public ArrayList<Ride> getRideList() {
		return rideList;
	}

	public void addRide(double distance, int time, String category) { // adds ride details to rideList
		this.rideList.add(new Ride(distance, time, category));
	}
}
