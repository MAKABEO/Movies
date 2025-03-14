package com.jaggaer.movies;


import com.jaggaer.movies.config.FacadeFactory;
import com.jaggaer.movies.exceptions.MovieRentalException;
import com.jaggaer.movies.facade.CustomerFacade;
import com.jaggaer.movies.facade.RentalFacade;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.model.enums.MovieType;
import com.jaggaer.movies.utils.StatementGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CustomerFacade customerFacade = FacadeFactory.getCustomerFacade();
            RentalFacade rentalFacade = FacadeFactory.getRentalFacade();

            Customer customer = new Customer("John Doe");
            customerFacade.registerCustomer(customer);

            List<Rental> rentals = createRentals();
            rentals.forEach(rental -> rentalFacade.registerRental(customer, rental));

            System.out.println(StatementGenerator.generateStatement(customer));
        } catch (MovieRentalException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static List<Rental> createRentals() {
        return List.of(
                new Rental(new Movie("Zack Snyder's Justice League", MovieType.NEW_RELEASE), 5),
                new Rental(new Movie("Terminator", MovieType.REGULAR), 1),
                new Rental(new Movie("Soul", MovieType.CHILDREN), 3)
        );
    }
}
