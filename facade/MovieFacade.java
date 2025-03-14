package movies.facade;

import movies.exceptions.InvalidMovieDataException;
import movies.exceptions.MovieNotFoundException;
import movies.exceptions.MovieRentalException;
import movies.model.Movie;
import movies.service.interfaces.IMovieService;

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
