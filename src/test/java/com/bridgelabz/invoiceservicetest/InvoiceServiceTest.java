package com.bridgelabz.invoiceservicetest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.invoiceservice.InvoiceService;
import com.bridgelabz.invoiceservice.InvoiceSummary;
import com.bridgelabz.invoiceservice.Ride;
import com.bridgelabz.invoiceservice.UserRepo;

public class InvoiceServiceTest {
	/**
	 * method to return fare, distance and time given
	 */
	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 2.0;
		int time = 5;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, totalFare, 0.0);
	}

	/**
	 * method to return minimum fare, less distance and time is given
	 */
	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
		InvoiceService invoiceService = new InvoiceService();
		double distance = 0.1;
		int time = 1;
		double totalFare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, totalFare, 0.0);
	}

	/**
	 * method to return invoice summary of multiple rides
	 */
	@Test
	public void givenMultipleRides_ShoulReturnInvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.5, 5), new Ride(0.1, 1), };
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 40.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	/**
	 * method to return invoice summary of normal multiple ride
	 */
	@Test
	public void givenUserIdAndNormalRideCategory_ShouldReturnInvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		UserRepo newUser = new UserRepo("abc");
		newUser.addRide(2.0, 5, "normal");
		newUser.addRide(0.5, 5, "normal");
		newUser.addRide(0.1, 1, "normal");
		ArrayList<Ride> rideListForId = InvoiceService.getListOfRides(newUser);
		InvoiceSummary invoiceSummary = InvoiceService.calculateFare(rideListForId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 40);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}

	/**
	 * method to return invoice summary of premium ride category 
	 */
	@Test
	public void givenUserIdAndPremiumRideCategory_ShouldReturnInvoiceSummary() {
		InvoiceService invoiceService = new InvoiceService();
		UserRepo newUser = new UserRepo("def");
		newUser.addRide(2.0, 5, "premium");
		newUser.addRide(0.5, 5, "premium");
		newUser.addRide(0.1, 1, "normal");
		ArrayList<Ride> rideListForId = InvoiceService.getListOfRides(newUser);
		InvoiceSummary invoiceSummary = invoiceService.calculateFare(rideListForId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 65);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
