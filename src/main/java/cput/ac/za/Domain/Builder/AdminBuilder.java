package cput.ac.za.Domain.Builder;

import cput.ac.za.Domain.Entity.Admin;

public interface AdminBuilder {
    public void createAdminID();
    public void createAdminType();
    public void createAdminFullName();
    public Admin getProduct();
}
