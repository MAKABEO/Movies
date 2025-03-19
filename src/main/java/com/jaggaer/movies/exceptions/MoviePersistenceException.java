package com.jaggaer.movies.exceptions;

public class MoviePersistenceException extends RuntimeException {
    public MoviePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
