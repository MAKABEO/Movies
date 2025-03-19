package com.jaggaer.movies.dao.impl;


import com.jaggaer.movies.dao.interfaces.IMovieDao;
import com.jaggaer.movies.exceptions.MoviePersistenceException;
import com.jaggaer.movies.model.Movie;
import com.jaggaer.movies.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class MovieDaoImpl implements IMovieDao {

    private final EntityManager entityManager;

    public MovieDaoImpl() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    @Override
    public void save(Movie movie) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException | IllegalStateException e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new MoviePersistenceException("Error saving movie: " + movie.getTitle(), e);
        }
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
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(movie);
            entityManager.getTransaction().commit();
        } catch (PersistenceException | IllegalStateException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new MoviePersistenceException("Error updating movie: " + movie.getId(), e);
        }
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
