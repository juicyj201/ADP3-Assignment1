package cput.ac.za.Domain.Entity;

public class Admin {
    public String adminID;
    public String adminType;
    public String adminFirstName;
    public String adminSurname;

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

    public Admin getAdmin(Admin admin){
        return admin;
    }
}
