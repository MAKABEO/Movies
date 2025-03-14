package movies.service.interfaces;

import movies.model.Customer;
import movies.model.Rental;

import java.util.List;

public interface IRentalService {
    void registerRental(Customer customer, Rental rental);
    Rental getRental(int id);
    List<Rental> getAllRentals();
    void updateRental(Rental rental);
    void deleteRental(int id);
}
