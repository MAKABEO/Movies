package com.jaggaer.movies.dao.impl;


import com.jaggaer.movies.dao.interfaces.IRentalDao;
import com.jaggaer.movies.model.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalDaoImpl implements IRentalDao {

    private final List<Rental> rentals = new ArrayList<>();

    @Override
    public void save(Rental entity) {
        rentals.add(entity);
    }

    @Override
    public Rental findById(int id) {
        return rentals.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Rental> findAll() {
        return new ArrayList<>(rentals);
    }

    @Override
    public void update(Rental entity) {
        delete(entity.getId());
        save(entity);
    }

    @Override
    public void delete(int id) {
        rentals.removeIf(c -> c.getId() == id);
    }
}
