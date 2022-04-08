package cput.ac.za.Repository;

public interface IRepository<T>{
    public T create(String id, T object);
    public T read(String id);
    public void update(String id, T object);
    public void delete(String id, T object);
}
