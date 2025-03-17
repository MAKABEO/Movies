package com.jaggaer.movies.service;



import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.model.RentalMovie;
import lombok.Getter;

import java.util.List;

@Getter
public class RentalStatementCalculator {

    private Rental rental;
    private double totalAmount;
    private int frequentRenterPoints;

    public RentalStatementCalculator(Rental rental) {
        this.rental = rental;
        this.totalAmount = 0;
        this.frequentRenterPoints = 0;
    }

    public void calculate() {
        List<RentalMovie> rentals = rental.getRentalMovies();
        for (RentalMovie rental : rentals) {
            totalAmount += rental.getMovie().getPriceType().calculateRentalAmount(rental.getDaysRented());
            frequentRenterPoints += rental.getMovie().getPriceType().calculateFrequentRenterPoints(rental.getDaysRented());
        }
    }
}
