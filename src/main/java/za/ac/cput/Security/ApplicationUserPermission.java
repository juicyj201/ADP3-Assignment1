package za.ac.cput.Security;

/**
 * This class contains application user permissions
 * ------------------------------------------------
 * Creates user permissions - So for student and order each access level has an attached permission
 * - Student has (READ, WRITE) and Order has (Read, Write)
 */
public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
