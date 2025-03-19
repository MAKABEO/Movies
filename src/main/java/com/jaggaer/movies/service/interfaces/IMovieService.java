package com.jaggaer.movies.service.interfaces;


import com.jaggaer.movies.model.Movie;

import java.util.List;

public interface IMovieService {
    void registerMovie(Movie movie);
    Movie getMovie(int id);
    List<Movie> getAllMovies();
    void updateMovie(Movie movie);
    void deleteMovie(int id);
}
