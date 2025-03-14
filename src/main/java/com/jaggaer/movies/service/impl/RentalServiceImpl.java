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
        if (rental == null || rental.getDaysRented() < 1) {
            throw new InvalidRentalDataException("Rental must have at least one day.");
        }

        if (customer == null) {
            throw new InvalidCustomerDataException("Customer cannot be null.");
        }

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
}
