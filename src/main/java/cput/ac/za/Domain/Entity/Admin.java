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

    public Admin(){
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
}
