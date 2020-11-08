package com.bridgelabz.invoiceservice;

public class InvoiceService {
	private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides)
            totalFare += this.calculateFare(ride.distance ,ride.time);
        return new InvoiceSummary(rides.length, totalFare);
    }
}
