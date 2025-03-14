package com.jaggaer.movies.dao.interfaces;


import com.jaggaer.movies.dao.interfaces.base.ICreate;
import com.jaggaer.movies.dao.interfaces.base.IDelete;
import com.jaggaer.movies.dao.interfaces.base.IRead;
import com.jaggaer.movies.dao.interfaces.base.IUpdate;
import com.jaggaer.movies.model.Movie;

public interface IMovieDao extends ICreate<Movie>, IRead<Movie>, IUpdate<Movie>, IDelete<Movie> {
}
