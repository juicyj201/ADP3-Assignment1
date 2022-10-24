package za.ac.cput.Controller;

import org.hibernate.validator.constraints.URL;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;

/**
 * Joshua Julies
 * 220102473
 * The admin controller test
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminControllerTest {
    @Autowired
    private AdminController controller;
    private final Admin admintestobject = new AdminFactory().buildAdmin(21L, "Manager", "John", "Banks");
    private final Admin admintestobject2 = new AdminFactory().buildAdmin(22L, "Manager", "John", "Banks");

    @LocalServerPort
    private int port;
    @URL
    private String local;
    @Autowired
    private TestRestTemplate temp;

    @BeforeEach
    public void setup(){
        local = ("http://localhost:"+port+"/admin");
    }

    @Test
    public void testSaveAdmin() throws NullPointerException {
        ResponseEntity<Admin> response = this.temp.postForEntity(local, admintestobject, Admin.class);
        System.out.println(response);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testReadAdmin() throws NullPointerException {
        ResponseEntity<Admin> response = this.temp.getForEntity(local+"/"+admintestobject.getAdminID(), Admin.class);
        System.out.println(response);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testReadAllAdmin(){
//        List<ResponseEntity<Admin>> responselist = null;
//        for(int i = 0; i < controller.getAllAdmin().size(); i++){
//            responselist.add(temp.getForEntity(local+admintestobject.getAdminID(), Admin.class));
//        }
//        System.out.println(responselist.get(0));
//        Assertions.assertNotNull(responselist);
//        Assertions.assertEquals(HttpStatus.OK, responselist.get(0).getStatusCode());
    }

    @Test
    public void testUpdateAdmin(){
        ResponseEntity<Admin> response = this.temp.getForEntity(local+"/"+admintestobject.getAdminID(), Admin.class);
        temp.put(String.valueOf(local), admintestobject2, Admin.class);
        ResponseEntity<Admin> response2 = this.temp.getForEntity(local+"/"+admintestobject2.getAdminID(), Admin.class);
        System.out.println("First: "+response+"Second: "+response2);
        Assertions.assertNotNull(response2);
        Assertions.assertEquals(HttpStatus.OK, response2.getStatusCode());
    }

    @Test
    public void testDeleteAdmin(){
        this.temp.delete(String.valueOf(local), admintestobject);
        System.out.println(admintestobject.toString());
    }
}
