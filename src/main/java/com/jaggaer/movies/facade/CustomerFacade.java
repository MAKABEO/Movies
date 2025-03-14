package com.jaggaer.movies.facade;



import com.jaggaer.movies.exceptions.CustomerNotFoundException;
import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.exceptions.MovieRentalException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.service.interfaces.ICustomerService;

import java.util.List;

public class CustomerFacade {
    private final ICustomerService customerService;

    public CustomerFacade(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public void registerCustomer(Customer customer) {
        try {
            customerService.registerCustomer(customer);
        } catch (InvalidCustomerDataException e) {
            throw new MovieRentalException("Error registering customer: " + e.getMessage());
        }
    }

    public Customer getCustomer(int id) {
        try {
            return customerService.getCustomer(id);
        } catch (CustomerNotFoundException e) {
            throw new MovieRentalException("Customer not found: " + e.getMessage());
        }
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerService.deleteCustomer(id);
    }
}
