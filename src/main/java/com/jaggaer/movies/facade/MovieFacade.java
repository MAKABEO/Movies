package com.jaggaer.movies.facade;


import com.jaggaer.movies.exceptions.InvalidMovieDataException;
import com.jaggaer.movies.exceptions.MovieNotFoundException;
import com.jaggaer.movies.exceptions.MovieRentalException;
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
        } catch (InvalidMovieDataException e) {
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
        movieService.updateMovie(movie);
    }

    public void deleteMovie(int id) {
        movieService.deleteMovie(id);
    }
}
