package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Util.Validation;

/**
 * Joshua Julies
 * 220102473
 * The admin factory
 */

public class AdminFactory {
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
