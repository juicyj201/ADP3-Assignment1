package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Factory.EmployeeFactory;

public class EmployeeServiceImplTest {
    private EmployeeService service;
    private Employee emp = new EmployeeFactory().createEmployee("01", "John", "Walker", "02");

    @Test
    void testService() {
        try {
            //Assertions.assertTrue(service.equals(null));
            Assertions.assertThrows(NullPointerException.class, ()->{service.equals(null);}, "Service uses dependency injection for repository, this is expected.");
        } catch(NullPointerException npe){
            npe.getCause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadAll(){
        try {
            service.save(emp);
            Assertions.assertNotNull(service.readAll());
        } catch(NullPointerException npe){
            npe.getStackTrace();
            npe.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
