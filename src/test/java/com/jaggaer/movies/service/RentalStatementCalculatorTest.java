package com.jaggaer.movies.service;

import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.model.RentalMovie;
import com.jaggaer.movies.model.enums.MovieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalStatementCalculatorTest {

    private Rental rental;
    private RentalStatementCalculator calculator;

    @BeforeEach
    void setUp() {
        rental = new Rental();
    }

    @Test
    void calculate_ShouldComputeTotalAmountAndFrequentRenterPoints() {
        MovieType newReleaseType = MovieType.NEW_RELEASE;
        MovieType regularType = MovieType.REGULAR;

        RentalMovie rentalMovie1 = mock(RentalMovie.class);
        RentalMovie rentalMovie2 = mock(RentalMovie.class);

        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);

        when(movie1.getPriceType()).thenReturn(newReleaseType);
        when(movie2.getPriceType()).thenReturn(regularType);

        when(rentalMovie1.getMovie()).thenReturn(movie1);
        when(rentalMovie1.getDaysRented()).thenReturn(5);
        when(rentalMovie2.getMovie()).thenReturn(movie2);
        when(rentalMovie2.getDaysRented()).thenReturn(3);

        rental.setRentalMovies(Arrays.asList(rentalMovie1, rentalMovie2));

        calculator = new RentalStatementCalculator(rental);
        calculator.calculate();

        assertEquals(18.5, calculator.getTotalAmount(), 0.01);
        assertEquals(2, calculator.getFrequentRenterPoints());
    }
}
