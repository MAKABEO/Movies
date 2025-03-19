package com.jaggaer.movies.utils;

import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.model.RentalMovie;
import com.jaggaer.movies.service.RentalStatementCalculator;

import java.util.List;

public class StatementGenerator {
    public static String generateStatement(Customer customer, Rental rental) {
        RentalStatementCalculator calculator = new RentalStatementCalculator(rental);
        calculator.calculate();

        StringBuilder statement = new StringBuilder();
        statement.append("Rental Record for ").append(customer.getName()).append("\n");

        List<RentalMovie> rentals = rental.getRentalMovies();
        for (RentalMovie rentalMovie : rentals) {
            statement.append("\t").append(rentalMovie.getMovie().getTitle())
                    .append("\t").append(rentalMovie.getMovie().getPriceType().calculateRentalAmount(rentalMovie.getDaysRented())).append("\n");
        }

        statement.append("Amount owed is ").append(calculator.getTotalAmount()).append("\n");
        statement.append("You earned ").append(calculator.getFrequentRenterPoints())
                .append(" frequent renter points");

        return statement.toString();
    }
}
