package movies.service.interfaces;

import movies.model.Movie;

import java.util.List;

public interface IMovieService {
    void registerMovie(Movie movie);
    Movie getMovie(int id);
    List<Movie> getAllMovies();
    void updateMovie(Movie movie);
    void deleteMovie(int id);
}
