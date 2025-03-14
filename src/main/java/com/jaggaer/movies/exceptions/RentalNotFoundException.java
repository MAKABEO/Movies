package com.jaggaer.movies.exceptions;

public class RentalNotFoundException extends MovieRentalException {
    public RentalNotFoundException(int rentalId) {
        super("Rental with ID " + rentalId + " not found.");
    }
}
