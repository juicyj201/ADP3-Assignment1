package za.ac.cput.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static za.ac.cput.Security.ApplicationUserPermission.*;

// Contains application user roles
public enum ApplicationUserRole {

    //Student has no permission
    STUDENT(Sets.newHashSet()),
    //Employee has the order read and student read permissions
    EMPLOYEE(Sets.newHashSet(ORDER_READ, STUDENT_READ)),
    //Admin has the order -> (Read and Write) and student has -> (Read and Write) permissions
    ADMIN(Sets.newHashSet(ORDER_READ, ORDER_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
