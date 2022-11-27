package za.ac.cput.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.Domain.Entity.Student;

import java.util.Collection;
import java.util.Collections;

public class StudentUserDetails implements UserDetails {
    private final Student student;
    public StudentUserDetails(Student student){
        this.student = student;
    }

    /**
     * @method getAuthorities
     * ----------------------
     * This method checks and adds the student's granted authority.
     * The student has limited access compared to the admin.
     *
     * @return - the student role
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_STUDENT";
            }
        });
    }

    /**
     * @method getPassword
     * -------------------
     * Initialises the password encoder object and scrambles
     * the student user password for safety purposes.
     *
     * @return - it returns the encoded password
     */
    @Override
    public String getPassword() {
        PasswordConfig pconfig = new PasswordConfig();
        PasswordEncoder encoder = pconfig.passwordEncoder();
        return encoder.encode(student.getPassword());
    }

    /**
     * @method getUsername
     * -------------------
     * Retrieves the student first name as a placeholder
     * for the login username.
     *
     * @return - it returns the username object
     */
    @Override
    public String getUsername() {
        return this.student.getStudFirstName();
    }

    /**
     * @method isAccountNonExpired
     * ---------------------------
     * This method is used to check whether the account is expired
     *
     * @return - this is a boolean value
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @method isAccountNonLocked
     * ---------------------------
     * This method is used to check whether the account is locked
     *
     * @return - this is a boolean value
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @method isCredentialsNonExpired
     * ---------------------------
     * This method is used to check whether the credentials is expired
     *
     * @return - this is a boolean value
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @method isEnabled
     * ---------------------------
     * This method is used to check whether the user account is enabled for use
     *
     * @return - this is a boolean value
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
