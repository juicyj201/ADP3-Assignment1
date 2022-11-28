package za.ac.cput.Service;

import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The generic service interface
 * -----------------------------
 * This interface will alone have the explanation for all crud operations.
 * Adding documentation for each method in each service and its implementation
 * will be redundant and unnecessary.
 */

public interface IService <T, ID>{
    /**
     * This method saves an entity to the database using JPA.
     * @param entity - this is the entity object to be saved
     * @return - it returns a saved entity if successful
     */
    public T save(T entity);

    /**
     * This method reads an entity using it's PK or an object itself.
     * @param ID - this is the PK of the entity
     * @return - returns a full entity object on successful read execution
     */
    public Optional<T> read(Long ID);

    /**
     * This method updates a database entity.
     * @param entity - this is the updated entity object
     * @return - it returns the newly updated database entity
     */
    public T update(T entity);

    /**
     * This method deletes a database entity, with no return value
     * @param entity - this is the entity to be deleted
     */
    public void delete(T entity);
}
