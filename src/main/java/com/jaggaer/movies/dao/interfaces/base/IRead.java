package com.jaggaer.movies.dao.interfaces.base;

import java.util.List;

public interface IRead<T> {
    T findById(int id);
    List<T> findAll();
}
