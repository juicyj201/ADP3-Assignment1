package za.ac.cput.Security;

import org.apache.catalina.session.PersistentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import za.ac.cput.Service.Impl.AdminServiceImpl;
import za.ac.cput.Service.Impl.CustomUserDetailsService;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;
import za.ac.cput.Service.Impl.StudentServiceImpl;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AdminServiceImpl adminserv;
    @Autowired
    private EmployeeServiceImpl empserv;
    @Autowired
    private StudentServiceImpl studserv;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    /**
     * This is similar to the other config methods
     * however, this allows the custom user details to be set
     * @param auth - the authentication manager object
     * @throws Exception - general exception handling
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Similar to the configure method using the http parameter.
     * We do not use this method to it's full extent, for redundancy reasons.
     * @param web - this allows us to use the web security support
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/Error");
    }

    /**
     * This method allows the site administrator (us) to change
     * the access to the web pages. There are several configurations
     * made, but the most important sections include the csrf token,
     * antMatchers, login info, rememberme, and logout info.
     * @param http - this allows us to use the http security support for website administration
     * @throws Exception - this is required by the http method call should any errors arise
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/**", "/static/**", "/js/**", "/images/**", "/h2/**", "/Error").permitAll()
                 /**
                  * Maps permissions to api - this means that you need a certain permission to access or use the api
                  * Uses permissions to access/protect api -> .hasAuthority(permission)
                  * Order in which the antMatchers are specified matters
                  * - e.g. if you allow give student access to an api before you add an Admin access layer
                  * than the student will be able to access it
                  **/
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .successHandler(new UserSuccessAuthenticationHandler())
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/home", true)
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                .rememberMe()
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    .key("somethingverysecured")
                    .rememberMeParameter("remember-me").
                and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login").
                and()
                .headers().frameOptions().sameOrigin();
    }
}
