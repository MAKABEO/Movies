package com.jaggaer.movies.dao.impl;

import com.jaggaer.movies.dao.interfaces.ICustomerDao;
import com.jaggaer.movies.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {

    private final List<Customer> customers = new ArrayList<>();

    @Override
    public void save(Customer entity) {
        customers.add(entity);
    }

    @Override
    public Customer findById(int id) {
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public void update(Customer entity) {
        delete(entity.getId());
        save(entity);
    }

    @Override
    public void delete(int id) {
        customers.removeIf(c -> c.getId() == id);
    }
}
