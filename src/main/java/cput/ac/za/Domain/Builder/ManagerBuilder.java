package cput.ac.za.Domain.Builder;

import cput.ac.za.Domain.Entity.Admin;

public class ManagerBuilder implements AdminBuilder{
    private Admin admin;

    public ManagerBuilder(){
        this.admin = new Admin();
    }

    @Override
    public void createAdminID(){
        admin.setAdminID("adManJohn01");
    }

    @Override
    public void createAdminType() {
        admin.setAdminType("Manager");
    }

    @Override
    public void createAdminFullName() {
        admin.setAdminFullName("Johnathan", "Mayweather");
    }

    @Override
    public Admin getProduct() {
        return admin;
    }
}
