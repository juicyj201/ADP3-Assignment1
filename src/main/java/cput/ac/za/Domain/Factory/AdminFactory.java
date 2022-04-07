package cput.ac.za.Domain.Factory;

import cput.ac.za.Domain.Builder.Director;
import cput.ac.za.Domain.Builder.ManagerBuilder;
import cput.ac.za.Domain.Entity.Admin;

public class AdminFactory {
    public Admin getAdmin(String choice){
        if(choice.equalsIgnoreCase("adminJohn")){
            ManagerBuilder manBuilder = new ManagerBuilder();
            Director director = new Director(manBuilder);
            director.constructManagerAccount();

            return director.getManager();
        }else {
            return null;
        }
    }
}
