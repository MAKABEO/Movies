package com.jaggaer.movies;


import com.jaggaer.movies.config.FacadeFactory;
import com.jaggaer.movies.exceptions.MovieRentalException;
import com.jaggaer.movies.facade.CustomerFacade;
import com.jaggaer.movies.facade.MovieFacade;
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
            MovieFacade movieFacade = FacadeFactory.getMovieFacade();

            Customer customer = getOrCreateCustomer(customerFacade, "John Doe");

            Rental rental = createRental();
            rental.getRentalMovies().forEach(rentalMovie -> movieFacade.registerMovie(rentalMovie.getMovie()));
            rentalFacade.registerRental(customer, rental);

            System.out.println(StatementGenerator.generateStatement(customer,rental));
        } catch (MovieRentalException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static Customer getOrCreateCustomer(CustomerFacade customerFacade, String name) {
        try {
            return customerFacade.getCustomerByName(name);
        } catch (MovieRentalException e) {
            Customer newCustomer = new Customer(name);
            customerFacade.registerCustomer(newCustomer);
            return newCustomer;
        }
    }

    private static Rental createRental() {
        Rental rental = new Rental();
        rental.addMovie(new Movie("Zack Snyder's Justice League", MovieType.NEW_RELEASE),5);
        rental.addMovie(new Movie("Terminator", MovieType.REGULAR), 1);
        rental.addMovie(new Movie("Soul", MovieType.CHILDREN), 3);
        return rental;
    }
}
