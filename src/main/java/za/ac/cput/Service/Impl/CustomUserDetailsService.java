package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Repository.EmployeeRepository;
import za.ac.cput.Repository.StudentRepository;
import za.ac.cput.Security.AdminUserDetails;
import za.ac.cput.Security.EmployeeUserDetails;
import za.ac.cput.Security.StudentUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private AdminRepository adminRepo;
    @Autowired
    private EmployeeRepository empRepo;

    /**
     * @param username - this is the attribute used to check and retrieve the user details
     * @return - this returns the UserDetails object for the three types of user roles
     * @throws UsernameNotFoundException - an exception raised when this username does not exist in the database
     * @method loadUserByUsername
     * --------------------------
     * This method checks the entire database for the username
     * and returns the user details if successful.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (studentRepo.findAll().iterator().next().getStudFirstName().equals(username)) {
            return new StudentUserDetails(studentRepo.findAll().iterator().next());
        } else if (empRepo.findAll().iterator().next().getEmpFirstName().equals(username)) {
            return new EmployeeUserDetails(empRepo.findAll().iterator().next());
        } else if (adminRepo.findAll().iterator().next().getAdminFirstName().equals(username)) {
            return new AdminUserDetails(adminRepo.findAll().iterator().next());
        } else {
            return null;
        }
    }
}
