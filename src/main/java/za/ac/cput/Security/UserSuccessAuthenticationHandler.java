package za.ac.cput.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class UserSuccessAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler userSuccess = new SimpleUrlAuthenticationSuccessHandler("/view-student-accounts");
    SimpleUrlAuthenticationSuccessHandler adminSuccess = new SimpleUrlAuthenticationSuccessHandler("/view-admin-accounts");

    /**
     * This checks whether a user has a certain role or authority
     * (namely Admin, Employee and Student) and redirects to the right address after authentication
     * has succeeded
     * @param request - This is the servlet request that comes from the previous page's redirect
     * @param response - This is the response we send on auth success
     * @param authentication - this allows us to access the different authority types
     * @throws IOException - Checks and raises input/output errors
     * @throws ServletException - Checks and raises http servlet errors
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority auth : authorities){
            if(auth.getAuthority().equals("ROLE_ADMIN"))
                this.adminSuccess.onAuthenticationSuccess(request, response, authentication);
        }

        this.userSuccess.onAuthenticationSuccess(request, response, authentication);
    }
}
