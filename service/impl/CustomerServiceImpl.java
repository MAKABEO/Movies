package movies.service.impl;

import movies.dao.interfaces.ICustomerDao;
import movies.exceptions.CustomerNotFoundException;
import movies.exceptions.InvalidCustomerDataException;
import movies.model.Customer;
import movies.service.interfaces.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao;

    public CustomerServiceImpl(ICustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public void registerCustomer(Customer customer) {
        if (customer == null || customer.getName().isEmpty()) {
            throw new InvalidCustomerDataException("Customer name cannot be empty.");
        }
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = customerDao.findById(id);
        if (customer == null) {
            throw new CustomerNotFoundException(id);
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }
}
