package com.jaggaer.movies.dao.interfaces;


import com.jaggaer.movies.dao.interfaces.base.ICreate;
import com.jaggaer.movies.dao.interfaces.base.IDelete;
import com.jaggaer.movies.dao.interfaces.base.IRead;
import com.jaggaer.movies.dao.interfaces.base.IUpdate;
import com.jaggaer.movies.model.Rental;

public interface IRentalDao extends ICreate<Rental>, IRead<Rental>, IUpdate<Rental>, IDelete<Rental> {
}
