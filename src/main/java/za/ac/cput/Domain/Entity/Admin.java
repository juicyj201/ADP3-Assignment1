package za.ac.cput.Domain.Entity;

import javax.persistence.*;

/**
 * Joshua Julies
 * 220102473
 * The admin entity
 */

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue
    private String adminID;
    @Column(name = "adminType")
    private String adminType;
    @Column(name = "adminFirstName")
    private String adminFirstName;
    @Column(name = "adminSurname")
    private String adminSurname;

    public Admin(AdminBuilder adminBuilder){
        this.adminID = adminID;
        this.adminType = adminType;
        this.adminFirstName = adminFirstName;
        this.adminSurname = adminSurname;
    }

    public Admin(){
        //empty constructor
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString(){
        return this.adminID + ", " + this.adminFirstName + ", " + this.adminSurname + ", " + this.adminType;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.clone();
    }

    public static class AdminBuilder{
        private String adminID;
        private String adminType;
        private String adminFirstName;
        private String adminSurname;

        public AdminBuilder(){
            this.adminID = adminID;
            this.adminType = adminType;
            this.adminFirstName = adminFirstName;
            this.adminSurname = adminSurname;
        }

        public AdminBuilder createAdminName(String adminFirstName, String adminSurname){
            this.adminFirstName = adminFirstName;
            this.adminSurname = adminSurname;
            return this;
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
