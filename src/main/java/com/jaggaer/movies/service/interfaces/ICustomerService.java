package com.jaggaer.movies.service.interfaces;


import com.jaggaer.movies.model.Customer;

import java.util.List;

public interface ICustomerService {
    void registerCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomerByName(String name);
}
