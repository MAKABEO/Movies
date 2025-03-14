package com.jaggaer.movies.service.impl;


import com.jaggaer.movies.dao.interfaces.IMovieDao;
import com.jaggaer.movies.exceptions.InvalidMovieDataException;
import com.jaggaer.movies.exceptions.MovieNotFoundException;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.service.interfaces.IMovieService;

import java.util.List;

public class MovieServiceImpl implements IMovieService {

    private IMovieDao movieDao;

    public MovieServiceImpl(IMovieDao movieDao){
        this.movieDao = movieDao;
    }

    @Override
    public void registerMovie(Movie movie) {
        if (movie == null || movie.getTitle().isEmpty()) {
            throw new InvalidMovieDataException("Movie title cannot be null or empty.");
        }
        movieDao.save(movie);
    }

    @Override
    public Movie getMovie(int id) {
        Movie movie = movieDao.findById(id);
        if (movie == null) {
            throw new MovieNotFoundException(id);
        }
        return movie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public void updateMovie(Movie movie) {
        movieDao.update(movie);
    }

    @Override
    public void deleteMovie(int id) {
        movieDao.delete(id);
    }
}
