package movies.dao.interfaces;

import movies.dao.interfaces.base.ICreate;
import movies.dao.interfaces.base.IDelete;
import movies.dao.interfaces.base.IRead;
import movies.dao.interfaces.base.IUpdate;
import movies.model.Customer;

public interface ICustomerDao extends ICreate<Customer>, IRead<Customer>, IUpdate<Customer>, IDelete<Customer> {
}
