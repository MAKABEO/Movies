package com.jaggaer.movies.facade;


import com.jaggaer.movies.exceptions.*;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.service.interfaces.IMovieService;

import java.util.List;

public class MovieFacade {
    private final IMovieService movieService;

    public MovieFacade(IMovieService movieService) {
        this.movieService = movieService;
    }

    public void registerMovie(Movie movie) {
        try {
            movieService.registerMovie(movie);
        } catch (InvalidMovieDataException | MoviePersistenceException e) {
            throw new MovieRentalException("Error registering movie: " + e.getMessage());
        }
    }

    public Movie getMovie(int id) {
        try {
            return movieService.getMovie(id);
        } catch (MovieNotFoundException e) {
            throw new MovieRentalException("Movie not found: " + e.getMessage());
        }
    }

    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    public void updateMovie(Movie movie) {
        try {
            movieService.updateMovie(movie);
        } catch (MoviePersistenceException e) {
            throw new MovieRentalException("Error registering customer: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        movieService.deleteMovie(id);
    }
}
