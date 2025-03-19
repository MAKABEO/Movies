package com.jaggaer.movies.dao.impl;

import com.jaggaer.movies.dao.interfaces.ICustomerDao;
import com.jaggaer.movies.exceptions.CustomerPersistenceException;
import com.jaggaer.movies.model.Customer;
import com.jaggaer.movies.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {

    private final EntityManager entityManager;

    public CustomerDaoImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Customer customer) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException | IllegalStateException e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new CustomerPersistenceException("Error saving customer: " + customer.getName(), e);
        }
    }

    @Override
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public void update(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(customer);
            entityManager.getTransaction().commit();
        } catch (PersistenceException | IllegalStateException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new CustomerPersistenceException("Error updating customer: " + customer.getId(), e);
        }
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        if (customer != null) {
            entityManager.remove(customer);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Customer findByName(String name) {
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT c FROM Customer c WHERE c.name = :name", Customer.class);
        query.setParameter("name", name);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
