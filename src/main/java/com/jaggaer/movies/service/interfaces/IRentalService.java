package com.jaggaer.movies.service.interfaces;


import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Rental;

import java.util.List;

public interface IRentalService {
    void registerRental(Customer customer, Rental rental);
    Rental getRental(int id);
    List<Rental> getAllRentals();
    void updateRental(Rental rental);
    void deleteRental(int id);
}
