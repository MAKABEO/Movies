package movies.dao.interfaces;

import movies.dao.interfaces.base.ICreate;
import movies.dao.interfaces.base.IDelete;
import movies.dao.interfaces.base.IRead;
import movies.dao.interfaces.base.IUpdate;
import movies.model.Movie;

public interface IMovieDao extends ICreate<Movie>, IRead<Movie>, IUpdate<Movie>, IDelete<Movie> {
}
