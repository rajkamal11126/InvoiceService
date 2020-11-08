package com.bridgelabz.invoiceservice;

import java.util.ArrayList;

public class UserRepo {
	String userid;
	private ArrayList<Ride> rideList;

	/**
	 * @param userid constructor of UserRepo to initialize user id and ride list using array list
	 */
	public UserRepo(String userid) {
		this.userid = userid;
		this.rideList = new ArrayList<>();
	}

	public ArrayList<Ride> getRideList() {
		return rideList;
	}

	public void addRide(double distance, int time) {
		this.rideList.add(new Ride(distance, time));
	}
}
