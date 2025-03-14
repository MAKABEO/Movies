package movies.exceptions;

public class CustomerNotFoundException extends MovieRentalException {
    public CustomerNotFoundException(int customerId) {
        super("Customer with ID " + customerId + " not found.");
    }
}
