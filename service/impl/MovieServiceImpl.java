package movies.service.impl;

import movies.dao.interfaces.IMovieDao;
import movies.exceptions.InvalidMovieDataException;
import movies.exceptions.MovieNotFoundException;
import movies.model.Movie;
import movies.service.interfaces.IMovieService;

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
