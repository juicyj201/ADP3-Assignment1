package cput.ac.za.Domain.Entity;

/**
 * Joshua Julies
 * 220102473
 * The admin entity
 */

public class Admin {
    private String adminID;
    private String adminType;
    private String adminFirstName;
    private String adminSurname;

    public Admin(AdminBuilder adminBuilder){
        this.adminID = adminID;
        this.adminType = adminType;
        this.adminFirstName = adminFirstName;
        this.adminSurname = adminSurname;
    }

    public void setAdminID(String adminID){
        this.adminID = adminID;
    }

    public void setAdminType(String adminType){
        this.adminType = adminType;
    }

    public void setAdminFullName(String adminFirstName, String adminSurname){
        this.adminFirstName = adminFirstName;
        this.adminSurname = adminSurname;
    }

    public String getAdminID(){
        return adminID;
    }

    public String getAdminType(){
        return adminType;
    }

    public String getAdminFullName(){
        return adminFirstName + " " + adminSurname;
    }

    public String getAdminFirstName(){
        return adminFirstName;
    }

    public String getAdminSurname(){
        return adminSurname;
    }
        @Override
    public String toString(){
        return this.adminID + ", " + this.adminFirstName + ", " + this.adminSurname + ", " + this.adminType;
    }

    public void destroyAdmin(Admin admin){
        admin.setAdminID(null);
        admin.setAdminType(null);
        admin.setAdminFullName(null, null);
        admin = null;
    }



    public static class AdminBuilder{
        private String adminID;
        private String adminType;
        private String adminFirstName;
        private String adminSurname;

        public AdminBuilder(String adminFirstName, String adminSurname){
            this.adminFirstName = adminFirstName;
            this.adminSurname = adminSurname;
        }

        public AdminBuilder createAdminID(String adminID){
            this.adminID = adminID;
            return this;
        }

        public AdminBuilder createAdminType(String adminType){
            this.adminType = adminType;
            return this;
        }



        public Admin build(){
            Admin admin = new Admin(this);
            return admin;
        }
    }
}
