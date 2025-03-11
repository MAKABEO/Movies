package movies;

import movies.model.Customer;
import movies.model.Movie;
import movies.model.Rental;
import movies.model.enums.MovieType;
import movies.utils.StatementGenerator;

public class Main {
    public static void main(String[] args) {
        Customer customer = createSampleData();
        String report = StatementGenerator.generateStatement(customer);
        System.out.println(report);
    }

    private static Customer createSampleData() {
        Customer customer = new Customer("Test");
        customer.addRental(new Rental(new Movie("Zack Snyder's Justice League", MovieType.NEW_RELEASE), 5));
        customer.addRental(new Rental(new Movie("Terminator", MovieType.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Soul", MovieType.CHILDREN), 3));
        return customer;
    }
}
