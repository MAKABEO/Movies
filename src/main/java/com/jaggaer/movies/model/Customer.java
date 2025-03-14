package com.jaggaer.movies.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public int getId(){
        return id;
    }
}
