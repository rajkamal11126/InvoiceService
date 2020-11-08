package com.bridgelabz.invoiceservice;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_MINUTE = 1;
	private static final double MINIMUM_FARE = 5;

	/**
	 * @param distance
	 * @param time
	 * @return total fare of cab
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
		if (totalFare < MINIMUM_FARE)
			return MINIMUM_FARE;
		return totalFare;
	}
}
