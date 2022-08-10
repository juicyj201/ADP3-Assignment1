package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;

/**
 * Joshua Julies
 * 220102473
 * The admin factory
 */

public class AdminFactory {
    public Admin getAdmin(String choice){
        if(choice.equalsIgnoreCase("adminJohn")){
            Admin admin;
            admin = new Admin.AdminBuilder("Johnathan", "Kawaski").build();

            return admin;
        }else {
            return null;
        }
    }
}
