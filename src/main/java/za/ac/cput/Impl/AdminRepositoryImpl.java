package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.IAdminRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdminRepositoryImpl implements IAdminRepository {
    private static AdminRepositoryImpl repo = null;
    private Map<String, Admin> adminDB = null;
    boolean result = false;

    private AdminRepositoryImpl(){
        adminDB = new HashMap<String, Admin>();
    }

    public static AdminRepositoryImpl getRepo(){
        if(repo == null){
            repo = new AdminRepositoryImpl();
            return repo;
        }else{
            return null;
        }
    }

    @Override
    public Admin create(String id, Admin object) {
        //where id = adminID & object = admin
        adminDB.put(id, object);
        if(!adminDB.containsKey(id)){
            return null;
        }else{
            return object;
        }
    }

    @Override
    public Admin read(String id) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equals(id)){
                return a;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Admin object) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equals(id)){
                //a.setAdminID(object.getAdminID());
                //a.setAdminType(object.getAdminType());
                //a.setAdminFullName(object.getAdminFirstName(), object.getAdminSurname());
                adminDB.replace(id, a, object);
            }
        }
    }

    @Override
    public void delete(String id, Admin object) {
        for(Admin a : adminDB.values()){
            if(a.getAdminID().equals(id)){
                adminDB.remove(id, object);
            }
        }
    }

    @Override
    public Map<String, Admin> getAll() {
        return adminDB;
    }
}
