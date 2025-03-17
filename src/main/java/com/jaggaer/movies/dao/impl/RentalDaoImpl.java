package com.jaggaer.movies.dao.impl;


import com.jaggaer.movies.dao.interfaces.IRentalDao;
import com.jaggaer.movies.model.Rental;
import com.jaggaer.movies.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RentalDaoImpl implements IRentalDao {

    private final EntityManager entityManager;

    public RentalDaoImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Rental rental) {
        entityManager.getTransaction().begin();
        entityManager.persist(rental);
        entityManager.getTransaction().commit();
    }

    @Override
    public Rental findById(int id) {
        return entityManager.find(Rental.class, id);
    }

    @Override
    public List<Rental> findAll() {
        return entityManager.createQuery("SELECT r FROM Rental r", Rental.class).getResultList();
    }

    @Override
    public void update(Rental rental) {
        entityManager.getTransaction().begin();
        entityManager.merge(rental);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Rental rental = entityManager.find(Rental.class, id);
        if (rental != null) {
            entityManager.remove(rental);
        }
        entityManager.getTransaction().commit();
    }
}
