package cput.ac.za.Domain.Repository;

public interface IRepository<T> {
    public void create();
    public T read();
    public void update();
    public void delete();
}
