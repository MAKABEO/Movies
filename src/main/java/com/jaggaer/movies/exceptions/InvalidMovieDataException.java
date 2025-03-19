package com.jaggaer.movies.exceptions;

public class InvalidMovieDataException extends MovieRentalException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
