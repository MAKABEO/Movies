package com.jaggaer.movies.service;

import com.jaggaer.movies.dao.impl.MovieDaoImpl;
import com.jaggaer.movies.exceptions.InvalidMovieDataException;
import com.jaggaer.movies.exceptions.MovieNotFoundException;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.model.enums.MovieType;
import com.jaggaer.movies.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {

    @Mock
    private MovieDaoImpl movieDao;

    @InjectMocks
    private MovieServiceImpl movieService;

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie("Inception", MovieType.NEW_RELEASE);
    }

    @Test
    void registerMovie_Success() {
        movieService.registerMovie(movie);
        verify(movieDao, times(1)).save(movie);
    }

    @Test
    void registerMovie_ThrowsInvalidMovieDataException_WhenMovieIsNull() {
        assertThrows(InvalidMovieDataException.class, () -> movieService.registerMovie(null));
    }

    @Test
    void registerMovie_ThrowsInvalidMovieDataException_WhenTitleIsEmpty() {
        Movie invalidMovie = new Movie("", MovieType.REGULAR);
        assertThrows(InvalidMovieDataException.class, () -> movieService.registerMovie(invalidMovie));
    }

    @Test
    void getMovie_Success() {
        when(movieDao.findById(1)).thenReturn(movie);
        Movie foundMovie = movieService.getMovie(1);
        assertNotNull(foundMovie);
        assertEquals("Inception", foundMovie.getTitle());
    }

    @Test
    void getMovie_ThrowsMovieNotFoundException_WhenMovieNotFound() {
        when(movieDao.findById(1)).thenReturn(null);
        assertThrows(MovieNotFoundException.class, () -> movieService.getMovie(1));
    }

    @Test
    void getAllMovies_Success() {
        List<Movie> movies = Arrays.asList(movie, new Movie("Titanic", MovieType.REGULAR));
        when(movieDao.findAll()).thenReturn(movies);
        List<Movie> result = movieService.getAllMovies();
        assertEquals(2, result.size());
    }

    @Test
    void updateMovie_Success() {
        movieService.updateMovie(movie);
        verify(movieDao, times(1)).update(movie);
    }

    @Test
    void deleteMovie_Success() {
        movieService.deleteMovie(1);
        verify(movieDao, times(1)).delete(1);
    }
}
