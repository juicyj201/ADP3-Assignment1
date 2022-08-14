package za.ac.cput.Service;

import java.util.List;
import java.util.Optional;

public interface IService <T, ID>{
    public T save(T entity);
    public Optional<T> read(T entity);
    public T update(T entity);
    public void delete(T entity);
}
