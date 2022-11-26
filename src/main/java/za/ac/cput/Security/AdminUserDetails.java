package za.ac.cput.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.Domain.Entity.Admin;

import java.util.Collection;
import java.util.Collections;

public class AdminUserDetails implements UserDetails {
    private final Admin admin;

    public AdminUserDetails(Admin admin){
        this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_ADMIN";
            }
        });
    }

    @Override
    public String getPassword() {
        PasswordConfig pconfig = new PasswordConfig();
        PasswordEncoder encoder = pconfig.passwordEncoder();
        return encoder.encode(admin.getPassword());
    }

    @Override
    public String getUsername() {
        return admin.getAdminFirstName();
    }

    //For the next few boolean return methods, these are hardcoded. I am going to have to add additional functionlaty for those items
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
