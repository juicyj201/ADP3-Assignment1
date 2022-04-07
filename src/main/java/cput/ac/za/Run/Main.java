package cput.ac.za.Run;

import cput.ac.za.Domain.Builder.Director;
import cput.ac.za.Domain.Builder.ManagerBuilder;
import cput.ac.za.Domain.Entity.Admin;
import cput.ac.za.Domain.Factory.AdminFactory;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        //test run for admin things
        Admin admin = new Admin();
        ManagerBuilder manBuilder = new ManagerBuilder();
        Director director = new Director(manBuilder);
        director.constructManagerAccount();
        admin = director.getManager();
        System.out.println(admin);

        Admin admin2 = new Admin();
        AdminFactory adminFac = new AdminFactory();
        admin2 = adminFac.getAdmin("adminJohn");
        System.out.println(admin2);
    }
}
