package za.ac.cput.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.Domain.Entity.Employee;

import java.util.Collection;
import java.util.Collections;

public class EmployeeUserDetails implements UserDetails {
    private final Employee employee;
    public EmployeeUserDetails(Employee employee){
        this.employee = employee;
    }

    /**
     * This method checks and adds the employee's granted authority.
     * The employee has limited access compared to the admin.
     * @return - the employee role
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_EMPLOYEE";
            }
        });
    }

    /**
     * Initialises the password encoder object and scrambles
     * the employee user password for safety purposes.
     * @return - it returns the encoded password
     */
    @Override
    public String getPassword() {
        PasswordConfig pconfig = new PasswordConfig();
        PasswordEncoder encoder = pconfig.passwordEncoder();
        return encoder.encode(employee.getPassword());
    }

    /**
     * Retrieves the employee first name as a placeholder
     * for the login username.
     * @return - it returns the username object
     */
    @Override
    public String getUsername() {
        return employee.getEmpFirstName();
    }

    /**
     * This method is used to check whether the account is expired
     * @return - this is a boolean value
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * This method is used to check whether the account is locked
     * @return - this is a boolean value
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * This method is used to check whether the credentials is expired
     * @return - this is a boolean value
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * This method is used to check whether the user account is enabled for use
     * @return - this is a boolean value
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
