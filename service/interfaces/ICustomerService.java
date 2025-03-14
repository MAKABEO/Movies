package movies.service.interfaces;

import movies.model.Customer;

import java.util.List;

public interface ICustomerService {
    void registerCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
