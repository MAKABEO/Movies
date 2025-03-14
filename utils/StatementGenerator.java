package movies.utils;

import movies.model.Customer;
import movies.model.Rental;
import movies.service.RentalStatementCalculator;

import java.util.List;

public class StatementGenerator {
    public static String generateStatement(Customer customer) {
        RentalStatementCalculator calculator = new RentalStatementCalculator(customer);
        calculator.calculate();

        StringBuilder statement = new StringBuilder();
        statement.append("Rental Record for ").append(customer.getName()).append("\n");

        List<Rental> rentals = customer.getRentals();
        for (Rental rental : rentals) {
            statement.append("\t").append(rental.getMovie().getTitle())
                    .append("\t").append(rental.calculateRentalAmount()).append("\n");
        }

        statement.append("Amount owed is ").append(calculator.getTotalAmount()).append("\n");
        statement.append("You earned ").append(calculator.getFrequentRenterPoints())
                .append(" frequent renter points");

        return statement.toString();
    }
}
