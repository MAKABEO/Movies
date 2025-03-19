package com.jaggaer.movies.facade;


import com.jaggaer.movies.exceptions.*;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.service.interfaces.IRentalService;

import java.util.List;

public class RentalFacade {

    private IRentalService rentalService;

    public RentalFacade(IRentalService rentalService) {
        this.rentalService = rentalService;
    }

    public void registerRental(Customer customer, Rental rental) {
        try {
            rentalService.registerRental(customer, rental);
        } catch (InvalidRentalDataException | InvalidCustomerDataException | RentalPersistenceException e) {
            throw new MovieRentalException("Error registering rental: " + e.getMessage());
        }
    }

    public Rental getRental(int id) {
        try {
            return rentalService.getRental(id);
        } catch (RentalNotFoundException e) {
            throw new MovieRentalException("Rental not found: " + e.getMessage());
        }
    }

    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    public void updateRental(Rental rental) {
        try {
            rentalService.updateRental(rental);
        } catch (RentalPersistenceException e) {
            throw new MovieRentalException("Error registering customer: " + e.getMessage());
        }
    }

    public void deleteRental(int id) {
        rentalService.deleteRental(id);
    }
}
