package com.jaggaer.movies.facade;


import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.exceptions.InvalidRentalDataException;
import com.jaggaer.movies.exceptions.MovieRentalException;
import com.jaggaer.movies.exceptions.RentalNotFoundException;
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
        } catch (InvalidRentalDataException | InvalidCustomerDataException e) {
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
        rentalService.updateRental(rental);
    }

    public void deleteRental(int id) {
        rentalService.deleteRental(id);
    }
}
