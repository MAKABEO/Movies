package com.jaggaer.movies.dao.interfaces;


import com.jaggaer.movies.dao.interfaces.base.ICreate;
import com.jaggaer.movies.dao.interfaces.base.IDelete;
import com.jaggaer.movies.dao.interfaces.base.IRead;
import com.jaggaer.movies.dao.interfaces.base.IUpdate;
import com.jaggaer.movies.model.Customer;

public interface ICustomerDao extends ICreate<Customer>, IRead<Customer>, IUpdate<Customer>, IDelete<Customer> {
    Customer findByName(String name);
}
