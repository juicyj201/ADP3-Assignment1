package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.IAdminRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Joshua Julies
 * 220102473
 * The admin repository implementation
 */

public class AdminRepositoryImpl implements IAdminRepository {
    private static AdminRepositoryImpl repo = null;
    private Set<Admin> adminDBSet = null;
    private Map<String, Admin> adminDB = null;

    public AdminRepositoryImpl(){
        adminDB = new HashMap<String, Admin>();
    }

    public static AdminRepositoryImpl getRepo(){
        if(repo == null){
            repo = new AdminRepositoryImpl();
            return repo;
        }
        return null;
    }

    @Override
    public Admin create(String id, Admin object) {
        //where id = adminID & object = admin
        adminDB.put(id, object);
        if(adminDB.containsKey(id)){
            return object;
        }
        return null;
    }

    @Override
    public Admin read(String id) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equalsIgnoreCase(id)){
                return a;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Admin object) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equals(id)){
                adminDB.replace(id, a, object);
            }
        }
    }

    @Override
    public boolean delete(String id) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equals(id)){
                adminDB.remove(id);
            }
        }
        return false;
    }

    @Override
    public Map<String, Admin> getAll() {
        return adminDB;
    }
}
