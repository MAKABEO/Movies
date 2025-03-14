package com.jaggaer.movies.config;


import com.jaggaer.movies.facade.CustomerFacade;
import com.jaggaer.movies.facade.MovieFacade;
import com.jaggaer.movies.facade.RentalFacade;

public class FacadeFactory {

    private static CustomerFacade customerFacade;
    private static MovieFacade movieFacade;
    private static RentalFacade rentalFacade;

    private FacadeFactory() {}

    public static CustomerFacade getCustomerFacade() {
        if (customerFacade == null) {
            customerFacade = new CustomerFacade(ServiceFactory.getCustomerService());
        }
        return customerFacade;
    }

    public static MovieFacade getMovieFacade() {
        if (movieFacade == null) {
            movieFacade = new MovieFacade(ServiceFactory.getMovieService());
        }
        return movieFacade;
    }

    public static RentalFacade getRentalFacade() {
        if (rentalFacade == null) {
            rentalFacade = new RentalFacade(ServiceFactory.getRentalService());
        }
        return rentalFacade;
    }
}
