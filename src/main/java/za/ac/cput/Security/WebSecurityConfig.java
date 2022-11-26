package za.ac.cput.Security;

import org.apache.catalina.session.PersistentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Service.Impl.AdminServiceImpl;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;
import za.ac.cput.Service.Impl.StudentServiceImpl;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static za.ac.cput.Security.ApplicationUserPermission.ORDER_WRITE;
import static za.ac.cput.Security.ApplicationUserPermission.STUDENT_WRITE;
import static za.ac.cput.Security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
// Informs application that method security is being used
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private AdminServiceImpl adminserv;
    @Autowired
    private EmployeeServiceImpl empserv;
    @Autowired
    private StudentServiceImpl studserv;

    /**
     * @method WebSecurityConfig()
     * -------------------------
     * Initialises the password encoder object for use in the
     * UserDetails method.
     *
     * @param passwordEncoder - this scrambles a user's password for safety purposes
     */
    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @method configure()
     * -----------------
     * Similar to the configure method using the http parameter.
     * We do not use this method to it's full extent, for redundancy reasons.
     *
     * @param web - this allows us to use the web security support
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/Error");
    }

    /**
     * @method configure()
     * -----------------
     * This method allows the site administrator (us) to change
     * the access to the web pages. There are several configurations
     * made, but the most important sections include the csrf token,
     * antMatchers, login info, rememberme, and logout info.
     *
     * @param http - this allows us to use the http security support for website administration
     * @throws Exception - this is required by the http method call should any errors arise
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/css/**", "/static/**", "/js/**", "/images/**", "/h2/**", "/Error").permitAll()
                // Maps permissions to api - this means that you need a certain permission to access or use the api
                // Uses permissions to access/protect api -> .hasAuthority(permission)
                // Order in which the antMatchers are specified matters
                // - e.g. if you allow give student access to an api before you add an Admin access layer
                // than the student will be able to access it
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

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails User1 = User.builder()
                //sets username for user
                .username("User1")
                //encodes password
                .password(passwordEncoder.encode("password"))
                // Assigns a role to user
                //.roles(STUDENT.name()) // ROLE_STUDENT
                // Assigns a permission to a user
                .authorities(STUDENT.getGrantedAuthorities())
                .build();

        UserDetails User2 = User.builder()
                .username("User2")
                .password(passwordEncoder.encode("password"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails User3 = User.builder()
                .username("User3")
                .password(passwordEncoder.encode("password"))
//                .roles(EMPLOYEE.name()) // ROLE_EMPLOYEE
                .authorities(EMPLOYEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                //Stores user in memory
                User1,
                User2,
                User3
        );
    }

    //ADD DOCUMENTATION FOR THIS
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//
//        if(adminserv.readAll() != null && empserv.readAll() != null && studserv.readAll() != null) {
//            List<Admin> adminlist = new ArrayList<Admin>(adminserv.readAll());
//            List<Employee> emplist = new ArrayList<Employee>(empserv.readAll());
//            List<Student> studlist = new ArrayList<Student>(studserv.readAll());
//
//            /**Added three for loops for every admin, employee and student
//             * Might seem redundant to have so much similar code, but since we don't know
//             * the amount of different admin, students and employees there might be
//             * that are all different, we do this dynamically.
//             **/
//            for (int i = 0; i < adminlist.size(); i++) {
//                manager.createUser((UserDetails) User.builder()
//                        .username(adminlist.get(i).getAdminFirstName())
//                        .password(passwordEncoder.encode(adminlist.get(i).getPassword()))
//                        .authorities(ADMIN.getGrantedAuthorities())
//                        .build());
//            }
//
//            for (int i = 0; i < emplist.size(); i++) {
//                manager.createUser((UserDetails) User.builder()
//                        .username(emplist.get(i).getEmpFirstName())
//                        .password(passwordEncoder.encode(emplist.get(i).getPassword()))
//                        .authorities(EMPLOYEE.getGrantedAuthorities())
//                        .build());
//            }
//
//            for (int i = 0; i < studlist.size(); i++) {
//                manager.createUser((UserDetails) User.builder()
//                        .username(studlist.get(i).getStudFirstName())
//                        .password(passwordEncoder.encode(studlist.get(i).getPassword()))
//                        .authorities(STUDENT.getGrantedAuthorities())
//                        .build());
//            }
//
//            return manager;
//        }
//
//        return null;
//    }
}
