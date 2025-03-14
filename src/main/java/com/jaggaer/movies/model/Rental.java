package com.jaggaer.movies.model;

public class Rental {
    private int id;
    private final Movie movie;
    private final int daysRented;
    private Customer customer;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateRentalAmount() {
        return movie.getPriceType().calculateRentalAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.getPriceType().calculateFrequentRenterPoints(daysRented);
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}