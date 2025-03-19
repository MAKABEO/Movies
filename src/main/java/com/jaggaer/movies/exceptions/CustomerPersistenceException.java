package com.jaggaer.movies.exceptions;

public class CustomerPersistenceException extends RuntimeException {
    public CustomerPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
