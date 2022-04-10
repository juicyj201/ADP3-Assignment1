package za.ac.cput.Repository;



/**
 * Joshua Julies
 * 220102473
 * The repository interface
 */

public interface IRepository<T>{
    public T create(String id, T object);
    public T read(String id);
    public void update(String id, T object);
    public boolean delete(String id);
}
