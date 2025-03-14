package com.jaggaer.movies.exceptions;

public class InvalidCustomerDataException extends MovieRentalException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}
