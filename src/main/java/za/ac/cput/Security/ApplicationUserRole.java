package za.ac.cput.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static za.ac.cput.Security.ApplicationUserPermission.*;

/**
 * This class contains application user roles
 * -------------------------------
 * 1. Student has no permission
 * 2. Employee has the order read and student read permissions
 * 3. Admin has the order -> (Read and Write) and student has -> (Read and Write) permissions
 */
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    EMPLOYEE(Sets.newHashSet(ORDER_READ, STUDENT_READ)),
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
