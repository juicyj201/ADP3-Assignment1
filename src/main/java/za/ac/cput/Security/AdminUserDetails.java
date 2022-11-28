package za.ac.cput.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.Domain.Entity.Admin;

import java.util.Collection;
import java.util.Collections;

public class AdminUserDetails implements UserDetails {
    private final Admin admin;
    public AdminUserDetails(Admin admin){
        this.admin = admin;
    }

    /**
     * This method checks and adds the admin's granted authorities.
     * The admin has full access and permission to the web app.
     * @return - the admin role
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
    }

    /**
     * Initialises the password encoder object and scrambles
     * the admin user password for safety purposes.
     * @return - it returns the encoded password
     */
    @Override
    public String getPassword() {
        PasswordConfig pconfig = new PasswordConfig();
        PasswordEncoder encoder = pconfig.passwordEncoder();
        return encoder.encode(admin.getPassword());
    }

    /**
     * Retrieves the admin first name as a placeholder
     * for the login username.
     * @return - it returns the username object
     */
    @Override
    public String getUsername() {
        return admin.getAdminFirstName();
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
