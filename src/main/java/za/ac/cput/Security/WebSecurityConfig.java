package za.ac.cput.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

import static za.ac.cput.Security.ApplicationUserPermission.ORDER_WRITE;
import static za.ac.cput.Security.ApplicationUserPermission.STUDENT_WRITE;
import static za.ac.cput.Security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
// Informs application that method security is being used
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

//    @Autowired
//    private AuthEntryPoint authEntryPoint;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/securityNone").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authEntryPoint);
//
//        http.addFilterAfter(new ResponseFilter(), ResponseFilter.class);
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> {requests
//                .antMatchers("/", "/css/*").permitAll()
//                .antMatchers("/h2/**").permitAll()
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/main/**").permitAll()
//                .antMatchers("/admin/**").permitAll()
//                .antMatchers("/employee/**").permitAll()
//                .anyRequest().authenticated();
//        });

//                .formLogin((form) -> form
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll());
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//        return http.build();
//    }

    private final PasswordEncoder passwordEncoder;

    //Invokes password encoder
    @Autowired
    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/favicon.ico", "/Error");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Adds layer of protection for any user logged into application against any request whilst logged in
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                //Authorize requests
                .authorizeRequests()
                //Allows any files in path that's in the antMatcher
                // to be permitted without authentication - permitAll()
                .antMatchers("/", "/index", "/css/**", "/static/**", "/js/**", "/images/**", "/h2/**", "/Error").permitAll()
                // User with role student has access only to main path
//                .antMatchers("/view-admin-accounts.html").hasRole(ADMIN.name())
//                .antMatchers("/view-student-accounts.html").hasRole(STUDENT.name())
//                .antMatchers("/main").hasRole(ADMIN.name())
//                .antMatchers("/main").hasRole(STUDENT.name())
                // Maps permissions to api - this means that you need a certain permission to access or use the api
                // Uses permissions to access/protect api -> .hasAuthority(permission)
                // Order in which the antMatchers are specified matters
                // - e.g. if you allow give student access to an api before you add an Admin access layer
                // than the student will be able to access it
//                .antMatchers(HttpMethod.DELETE,"/main", "/orders/**").hasAuthority(ORDER_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST,"/main", "/orders/**").hasAuthority(ORDER_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/main", "/orders/**").hasAuthority(ORDER_WRITE.getPermission())
                // Uses roles to access/protect api -> .hasAnyRole(ROLE.name)
//                .antMatchers(HttpMethod.GET,"/main", "/orders/**").hasAnyRole(ADMIN.name(), EMPLOYEE.name())
                //Authorize any request
                .anyRequest()
                //Authenticate any request - username and password
                .authenticated()
                .and()
                //Uses basic authentication
                //.httpBasic();
                // Uses form based authentication
                .formLogin()
                    // Shows login page
                    .successHandler(new UserSuccessAuthenticationHandler())
                    .loginPage("/login").permitAll()
                    // Default page after successful login, true to force redirect
//                    .defaultSuccessUrl("/main", true)
                    // Customize login page fields, incase you dont use the conventional password and username fields
                    .passwordParameter("password")
                    .usernameParameter("username")
                .and()
                // Defaults to 2 weeks
                .rememberMe()
                    //set custom expiration time (.tokenValiditySeconds)
                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                    // Remember me md5 Hash key
                    .key("somethingverysecured")
                    .rememberMeParameter("remember-me").
                and()
                //Logs user out of application
                .logout()
                    // Tells spring what to do after logout
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me")
                    .logoutSuccessUrl("/login");
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
                // Assigns a permissions to user
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

}
