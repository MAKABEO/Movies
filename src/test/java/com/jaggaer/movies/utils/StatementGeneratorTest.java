package com.jaggaer.movies.utils;

import com.jaggaer.movies.model.Customer;
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

public class StatementGeneratorTest {

    private Customer customer;
    private Rental rental;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe");
        rental = new Rental();
    }

    @Test
    void generateStatement_ShouldReturnCorrectStatement() {
        MovieType newReleaseType = MovieType.NEW_RELEASE;
        MovieType regularType = MovieType.REGULAR;

        Movie movie1 = mock(Movie.class);
        Movie movie2 = mock(Movie.class);

        when(movie1.getTitle()).thenReturn("Zack Snyder's Justice League");
        when(movie1.getPriceType()).thenReturn(newReleaseType);
        when(movie2.getTitle()).thenReturn("Terminator");
        when(movie2.getPriceType()).thenReturn(regularType);

        RentalMovie rentalMovie1 = mock(RentalMovie.class);
        RentalMovie rentalMovie2 = mock(RentalMovie.class);

        when(rentalMovie1.getMovie()).thenReturn(movie1);
        when(rentalMovie1.getDaysRented()).thenReturn(5);
        when(rentalMovie2.getMovie()).thenReturn(movie2);
        when(rentalMovie2.getDaysRented()).thenReturn(3);

        rental.setRentalMovies(Arrays.asList(rentalMovie1, rentalMovie2));

        String statement = StatementGenerator.generateStatement(customer, rental);

        String expectedStatement = """
                Rental Record for John Doe
                \tZack Snyder's Justice League\t15.0
                \tTerminator\t3.5
                Amount owed is 18.5
                You earned 2 frequent renter points""";

        assertEquals(expectedStatement, statement);
    }
}
