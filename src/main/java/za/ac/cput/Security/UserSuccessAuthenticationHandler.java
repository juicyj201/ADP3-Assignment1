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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority auth : authorities){
            //if user is admin
            if(auth.getAuthority().equals("ROLE_ADMIN"))
                this.adminSuccess.onAuthenticationSuccess(request, response, authentication);
        }

        //if user is not admin
        this.userSuccess.onAuthenticationSuccess(request, response, authentication);
    }
}
