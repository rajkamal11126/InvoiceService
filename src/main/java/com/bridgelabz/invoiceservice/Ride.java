package com.bridgelabz.invoiceservice;

public class Ride {
	public double distance;
	public int time;
	public String rideCategory;

	/**
	 * @param distance
	 * @param time     constructor of Ride class
	 */
	public Ride(double distance, int time, String rideCategory) {
		this.distance = distance;
		this.time = time;
		this.rideCategory = rideCategory;
	}

	@Override
	public String toString() {
		return "Ride{" + "distance=" + distance + ", time=" + time + '}';
	}
}
