package com.jaggaer.movies.dao.impl;


import com.jaggaer.movies.dao.interfaces.IMovieDao;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.utils.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MovieDaoImpl implements IMovieDao {

    private final EntityManager entityManager;

    public MovieDaoImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Movie movie) {
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
    }

    @Override
    public Movie findById(int id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public List<Movie> findAll() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    @Override
    public void update(Movie movie) {
        entityManager.getTransaction().begin();
        entityManager.merge(movie);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class, id);
        if (movie != null) {
            entityManager.remove(movie);
        }
        entityManager.getTransaction().commit();
    }
}
