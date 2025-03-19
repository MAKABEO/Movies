package com.jaggaer.movies.config;

import com.jaggaer.movies.dao.impl.CustomerDaoImpl;
import com.jaggaer.movies.dao.impl.MovieDaoImpl;
import com.jaggaer.movies.dao.impl.RentalDaoImpl;
import com.jaggaer.movies.service.impl.CustomerServiceImpl;
import com.jaggaer.movies.service.impl.MovieServiceImpl;
import com.jaggaer.movies.service.impl.RentalServiceImpl;
import com.jaggaer.movies.service.interfaces.ICustomerService;
import com.jaggaer.movies.service.interfaces.IMovieService;
import com.jaggaer.movies.service.interfaces.IRentalService;

public class ServiceFactory {
    private static ICustomerService customerService;
    private static IMovieService movieService;
    private static IRentalService rentalService;

    private ServiceFactory() {}

    public static ICustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(new CustomerDaoImpl());
        }
        return customerService;
    }

    public static IMovieService getMovieService() {
        if (movieService == null) {
            movieService = new MovieServiceImpl(new MovieDaoImpl());
        }
        return movieService;
    }

    public static IRentalService getRentalService() {
        if (rentalService == null) {
            rentalService = new RentalServiceImpl(new RentalDaoImpl());
        }
        return rentalService;
    }
}
