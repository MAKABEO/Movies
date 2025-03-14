package movies.service;

import movies.model.Customer;
import movies.model.Rental;

import java.util.List;

public class RentalStatementCalculator {

    private Customer customer;
    private double totalAmount;
    private int frequentRenterPoints;

    public RentalStatementCalculator(Customer customer) {
        this.customer = customer;
        this.totalAmount = 0;
        this.frequentRenterPoints = 0;
    }

    public void calculate() {
        List<Rental> rentals = customer.getRentals();
        for (Rental rental : rentals) {
            totalAmount += rental.calculateRentalAmount();
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}
