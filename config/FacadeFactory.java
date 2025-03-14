package movies.config;

import movies.facade.CustomerFacade;
import movies.facade.MovieFacade;
import movies.facade.RentalFacade;

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
