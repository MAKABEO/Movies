package com.jaggaer.movies.service;

import com.jaggaer.movies.dao.impl.CustomerDaoImpl;
import com.jaggaer.movies.exceptions.CustomerNotFoundException;
import com.jaggaer.movies.exceptions.InvalidCustomerDataException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.service.impl.CustomerServiceImpl;
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
public class CustomerServiceImplTest {

    @Mock
    private CustomerDaoImpl customerDao;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe");
    }

    @Test
    void testGetCustomerByName_WhenCustomerExists() {
        when(customerDao.findByName("John Doe")).thenReturn(customer);

        Customer result = customerService.getCustomerByName("John Doe");

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(customerDao, times(1)).findByName("John Doe");
    }

    @Test
    void testGetCustomerByName_WhenCustomerDoesNotExist() {
        when(customerDao.findByName("John Doe")).thenReturn(null);

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerByName("John Doe"));
        verify(customerDao, times(1)).findByName("John Doe");
    }

    @Test
    void testRegisterCustomer() {
        customerService.registerCustomer(customer);

        verify(customerDao, times(1)).save(customer);
    }

    @Test
    void registerCustomer_ShouldSaveCustomer() {
        customerService.registerCustomer(customer);
        verify(customerDao, times(1)).save(customer);
    }

    @Test
    void registerCustomer_ShouldThrowException_WhenCustomerIsNull() {
        assertThrows(InvalidCustomerDataException.class, () -> customerService.registerCustomer(null));
    }

    @Test
    void registerCustomer_ShouldThrowException_WhenCustomerNameIsEmpty() {
        Customer emptyCustomer = new Customer("");
        assertThrows(InvalidCustomerDataException.class, () -> customerService.registerCustomer(emptyCustomer));
    }

    @Test
    void getCustomer_ShouldReturnCustomer_WhenExists() {
        when(customerDao.findById(1)).thenReturn(customer);
        Customer found = customerService.getCustomer(1);
        assertEquals(customer, found);
    }

    @Test
    void getCustomer_ShouldThrowException_WhenCustomerNotFound() {
        when(customerDao.findById(1)).thenReturn(null);
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer(1));
    }

    @Test
    void getAllCustomers_ShouldReturnListOfCustomers() {
        List<Customer> customers = Arrays.asList(customer, new Customer("Jane Doe"));
        when(customerDao.findAll()).thenReturn(customers);
        List<Customer> result = customerService.getAllCustomers();
        assertEquals(2, result.size());
    }

    @Test
    void updateCustomer_ShouldCallUpdateOnDao() {
        customerService.updateCustomer(customer);
        verify(customerDao, times(1)).update(customer);
    }

    @Test
    void deleteCustomer_ShouldCallDeleteOnDao() {
        customerService.deleteCustomer(1);
        verify(customerDao, times(1)).delete(1);
    }

    @Test
    void getCustomerByName_ShouldReturnCustomer_WhenExists() {
        when(customerDao.findByName("John Doe")).thenReturn(customer);
        Customer found = customerService.getCustomerByName("John Doe");
        assertEquals(customer, found);
    }

    @Test
    void getCustomerByName_ShouldThrowException_WhenCustomerNotFound() {
        when(customerDao.findByName("John Doe")).thenReturn(null);
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerByName("John Doe"));
    }
}
