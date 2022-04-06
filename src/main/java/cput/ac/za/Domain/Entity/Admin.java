package cput.ac.za.Domain.Entity;

/**
 * Joshua Julies
 * 220102473
 * The admin entity
 */

public class Admin {
    public String adminID;
    public String adminType;
    public String adminFirstName;
    public String adminSurname;

    public Admin(AdminBuilder adminBuilder){
        this.adminID = adminID;
        this.adminType = adminType;
        this.adminFirstName = adminFirstName;
        this.adminSurname = adminSurname;
    }

    public String getAdminID(String adminID){
        return adminID;
    }

    public String getAdminType(String adminType){
        return adminType;
    }

    public String getAdminFullName(String adminFirstName, String adminSurname){
        return adminFirstName + adminSurname;
    }

    public static class AdminBuilder{
        public String adminID;
        public String adminType;
        public String adminFirstName;
        public String adminSurname;

        public AdminBuilder(String adminID, String adminFirstName, String adminSurname){
            this.adminID = adminID;
            this.adminFirstName = adminFirstName;
            this.adminSurname = adminSurname;
        }

        public AdminBuilder setAdminID(String adminID){
            this.adminID = adminID;
            return this;
        }

        public AdminBuilder setAdminType(String adminType){
            this.adminType = adminType;
            return this;
        }

        public AdminBuilder setAdminFullName(String adminFirstName, String adminSurname){
            this.adminFirstName = adminFirstName;
            this.adminSurname = adminSurname;
            return this;
        }

        public Admin buildAdmin(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
}
