package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Util.Validation;

/**
 * Joshua Julies
 * 220102473
 * The admin factory
 */

public class AdminFactory {
    /**
     * This method allows for the unlinked creation of admin objects.
     * It's use is however currently not that important. Once the
     * creation of database entities from this factory using a
     * mini-system has been designed, it will have more functionality
     * @param adminID - This is the PK of the admin object
     * @param adminType - This is the type of the admin user
     * @param adminFirstName - This is the first name of the admin
     * @param adminSurname - This is the surname of the admin
     * @return - the return object is a newly built admin entity for use
     */
    public Admin buildAdmin(Long adminID, String adminType, String adminFirstName, String adminSurname) {
        Admin admin = new Admin.AdminBuilder()
                .createAdminID(adminID)
                .createAdminType(adminType)
                .createAdminName(adminFirstName, adminSurname)
                .build();

        if (Validation.checkAdminNull(admin)) {
            throw new NullPointerException("This admin object is null");
        } else if (Validation.checkStringNullOrEmpty(String.valueOf(admin.getAdminID()), admin.getAdminType().toString(), adminFirstName.toString(), adminSurname.toString())){
            throw new NullPointerException("The attribute(s) of this admin object are null");
        }else{
            return admin;
        }
    }
}
