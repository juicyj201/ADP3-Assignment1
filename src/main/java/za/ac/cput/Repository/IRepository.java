package za.ac.cput.Repository;


import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The repository interface
 */

public interface IRepository<T, ID>{
    public T save(T t);
    public Optional<T> read(ID id);
    public void delete(T t);
}
