package com.jaggaer.movies.service.impl;


import com.jaggaer.movies.dao.interfaces.ICustomerDao;
import com.jaggaer.movies.exceptions.CustomerNotFoundException;
import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.service.interfaces.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public CustomerServiceImpl(ICustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public void registerCustomer(Customer customer) {
        if (customer == null || customer.getName().isEmpty()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty.");
        }
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = customerDao.findById(id);
        if (customer == null) {
            throw new CustomerNotFoundException(id);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer customer = customerDao.findByName(name);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with name '" + name + "' not found.");
        }
        return customer;
    }
}
