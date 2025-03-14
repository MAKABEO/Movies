package com.jaggaer.movies.dao.impl;


import com.jaggaer.movies.dao.interfaces.IMovieDao;
import com.jaggaer.movies.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements IMovieDao {

    private final List<Movie> movies = new ArrayList<>();

    @Override
    public void save(Movie entity) {
        movies.add(entity);
    }

    @Override
    public Movie findById(int id) {
        return movies.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies);
    }

    @Override
    public void update(Movie entity) {
        delete(entity.getId());
        save(entity);
    }

    @Override
    public void delete(int id) {
        movies.removeIf(c -> c.getId() == id);
    }
}
