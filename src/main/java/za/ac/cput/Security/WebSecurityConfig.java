package za.ac.cput.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
    private AuthenticationManager authMan;

    @Bean
    public InMemoryUserDetailsManager detailsManager(){
        UserDetails employee = User.withUsername("002").password(encoder().encode("jongcena")).roles("USER").build();
        UserDetails admin = User.withUsername("001").password(encoder().encode("superidol")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(employee, admin);
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public void auth(HttpServletRequest request, String username, String password){
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication = authMan.authenticate(authToken);
//        SecurityContext con = SecurityContextHolder.getContext();
//        con.setAuthentication(authentication);
//        HttpSession sesh = request.getSession(true);
//        sesh.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, con);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {requests
                .antMatchers("/").permitAll()
                .antMatchers("/h2/**").permitAll()
                .antMatchers("/main/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/employee/**").permitAll()
                .antMatchers("/student/**").permitAll()
                .anyRequest().authenticated();
        });

        http.formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                );

        //http.httpBasic(Customizer.withDefaults()).authorizeHttpRequests();

        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }
}
