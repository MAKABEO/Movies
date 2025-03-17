package com.jaggaer.movies.service;

import com.jaggaer.movies.dao.impl.RentalDaoImpl;
import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.exceptions.InvalidRentalDataException;
import com.jaggaer.movies.exceptions.RentalNotFoundException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.model.enums.MovieType;
import com.jaggaer.movies.service.impl.RentalServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RentalServiceImplTest {

    @Mock
    private RentalDaoImpl rentalDao;

    @InjectMocks
    private RentalServiceImpl rentalService;

    private Customer customer;
    private Rental rental;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe");
        rental = new Rental();
        rental.addMovie(new Movie("Matrix", MovieType.REGULAR), 3);
    }

    @Test
    void registerRental_ValidRental_Success() {
        rentalService.registerRental(customer, rental);
        verify(rentalDao, times(1)).save(rental);
    }

    @Test
    void registerRental_NullCustomer_ThrowsException() {
        assertThrows(InvalidCustomerDataException.class, () -> rentalService.registerRental(null, rental));
    }

    @Test
    void registerRental_EmptyMovies_ThrowsException() {
        Rental invalidRental = new Rental();
        assertThrows(InvalidRentalDataException.class, () -> rentalService.registerRental(customer, invalidRental));
    }

    @Test
    void registerRental_InvalidDaysRented_ThrowsException() {
        Rental invalidRental = new Rental();
        invalidRental.addMovie(new Movie("Inception", MovieType.NEW_RELEASE), 0);
        assertThrows(InvalidRentalDataException.class, () -> rentalService.registerRental(customer, invalidRental));
    }

    @Test
    void getRental_ExistingRental_ReturnsRental() {
        when(rentalDao.findById(1)).thenReturn(rental);
        Rental foundRental = rentalService.getRental(1);
        assertEquals(rental, foundRental);
    }

    @Test
    void getRental_NonExistingRental_ThrowsException() {
        when(rentalDao.findById(1)).thenReturn(null);
        assertThrows(RentalNotFoundException.class, () -> rentalService.getRental(1));
    }

    @Test
    void getAllRentals_ReturnsListOfRentals() {
        when(rentalDao.findAll()).thenReturn(List.of(rental));
        List<Rental> rentals = rentalService.getAllRentals();
        assertFalse(rentals.isEmpty());
        assertEquals(1, rentals.size());
    }

    @Test
    void updateRental_ValidRental_Success() {
        rentalService.updateRental(rental);
        verify(rentalDao, times(1)).update(rental);
    }

    @Test
    void deleteRental_ValidId_Success() {
        rentalService.deleteRental(1);
        verify(rentalDao, times(1)).delete(1);
    }
}
