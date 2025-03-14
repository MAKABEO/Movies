package movies.dao.interfaces;

import movies.dao.interfaces.base.ICreate;
import movies.dao.interfaces.base.IDelete;
import movies.dao.interfaces.base.IRead;
import movies.dao.interfaces.base.IUpdate;
import movies.model.Rental;

public interface IRentalDao extends ICreate<Rental>, IRead<Rental>, IUpdate<Rental>, IDelete<Rental> {
}
