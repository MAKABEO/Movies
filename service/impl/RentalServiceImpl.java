package movies.service.impl;

import movies.dao.interfaces.IRentalDao;
import movies.exceptions.InvalidCustomerDataException;
import movies.exceptions.InvalidRentalDataException;
import movies.exceptions.RentalNotFoundException;
import movies.model.Customer;
import movies.model.Rental;
import movies.service.interfaces.IRentalService;

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
