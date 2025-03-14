package movies;

import movies.config.FacadeFactory;
import movies.exceptions.MovieRentalException;
import movies.facade.CustomerFacade;
import movies.facade.RentalFacade;
import movies.model.Customer;
import movies.model.Movie;
import movies.model.Rental;
import movies.model.enums.MovieType;
import movies.utils.StatementGenerator;

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
