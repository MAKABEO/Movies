package movies.dao.interfaces.base;

public interface ICreate<T> {
    void save(T entity);
}
