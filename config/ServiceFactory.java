package movies.config;

import movies.dao.impl.CustomerDaoImpl;
import movies.dao.impl.MovieDaoImpl;
import movies.dao.impl.RentalDaoImpl;
import movies.service.impl.CustomerServiceImpl;
import movies.service.impl.MovieServiceImpl;
import movies.service.impl.RentalServiceImpl;
import movies.service.interfaces.ICustomerService;
import movies.service.interfaces.IMovieService;
import movies.service.interfaces.IRentalService;

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
