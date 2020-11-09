package com.bridgelabz.invoiceservice;

import java.util.ArrayList;

public class InvoiceService {

	private static final double MINIMUM_COST_PER_KM_NORMAL = 10.0;
	private static final int COST_PER_MINUTE_NORMAL = 1;
	private static final double MINIMUM_FARE_NORMAL = 5;
	private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
	private static final int COST_PER_MINUTE_PREMIUM = 2;
	private static final double MINIMUM_FARE_PREMIUM = 20;

	/**
	 * @param distance
	 * @param time
	 * @param rideCategory
	 * @return total fare
	 */
	public double calculateFare(double distance, int time, String rideCategory) {
		if (rideCategory.equals("normal")) {
			double totalFare = distance * MINIMUM_COST_PER_KM_NORMAL + time * COST_PER_MINUTE_NORMAL;
			return Math.max(totalFare, MINIMUM_FARE_NORMAL);
		} else {
			double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
			return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
		}
	}

	/**
	 * @param rides
	 * @return invoice summary of multiple rides
	 */
	public InvoiceSummary calculateFare(ArrayList<Ride> rides) {
		double totalFare = 0;
		for (Ride ride : rides)
			totalFare += this.calculateFare(ride.distance, ride.time, ride.rideCategory);
		return new InvoiceSummary(rides.size(), totalFare);
	}

	/**
	 * @param user
	 * @return ride list of user id
	 */
	public static ArrayList<Ride> getListOfRides(UserRepo user) {
		return user.getRideList();
	}
}
