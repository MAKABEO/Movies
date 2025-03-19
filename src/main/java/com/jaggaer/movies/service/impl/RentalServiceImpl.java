package com.jaggaer.movies.service.impl;


import com.jaggaer.movies.dao.interfaces.IRentalDao;
import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.exceptions.InvalidRentalDataException;
import com.jaggaer.movies.exceptions.RentalNotFoundException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.service.interfaces.IRentalService;

import java.util.List;

public class RentalServiceImpl implements IRentalService {
    private IRentalDao rentalDao;

    public RentalServiceImpl(IRentalDao rentalDao){
        this.rentalDao = rentalDao;
    }

    @Override
    public void registerRental(Customer customer, Rental rental) {
        if (customer == null) {
            throw new InvalidCustomerDataException("Customer cannot be null.");
        }
        validateRental(rental);

        rental.setCustomer(customer);
        customer.addRental(rental);
        rentalDao.save(rental);
    }

    @Override
    public Rental getRental(int id) {
        Rental rental = rentalDao.findById(id);
        if (rental == null) {
            throw new RentalNotFoundException(id);
        }
        return rental;
    }

    @Override
    public List<Rental> getAllRentals() {
        return rentalDao.findAll();
    }

    @Override
    public void updateRental(Rental rental) {
        rentalDao.update(rental);
    }

    @Override
    public void deleteRental(int id) {
        rentalDao.delete(id);
    }

    private void validateRental(Rental rental){
        if (rental == null || rental.getRentalMovies().isEmpty()) {
            throw new InvalidRentalDataException("You must rent at least one movie.");
        }

        rental.getRentalMovies().stream()
                .filter(rm -> rm.getDaysRented() < 1)
                .findFirst()
                .ifPresent(rm -> {
                    throw new InvalidRentalDataException("The movie '" + rm.getMovie().getTitle() + "' must be rented for at least one day.");
                });
    }
}
