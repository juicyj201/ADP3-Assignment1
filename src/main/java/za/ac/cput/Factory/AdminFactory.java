package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;

/**
 * Joshua Julies
 * 220102473
 * The admin factory
 */

public class AdminFactory {
    public Admin buildAdmin(String adminID, String adminType, String adminFirstName, String adminSurname) {
        Admin admin = new Admin.AdminBuilder()
                .createAdminID(adminID)
                .createAdminType(adminType)
                .createAdminName(adminFirstName, adminSurname)
                .build();

        return admin;
    }
}
