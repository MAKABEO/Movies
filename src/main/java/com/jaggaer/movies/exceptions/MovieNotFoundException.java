package com.jaggaer.movies.exceptions;

public class MovieNotFoundException extends MovieRentalException {
  public MovieNotFoundException(int movieId) {
    super("Movie with ID " + movieId + " not found.");
  }
}
