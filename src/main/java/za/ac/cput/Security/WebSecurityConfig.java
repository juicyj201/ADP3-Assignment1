package za.ac.cput.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebSecurityConfig{
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {requests
                .antMatchers("/").permitAll()
                .antMatchers("/h2/**").permitAll()
//                .antMatchers("/login/**").permitAll()
                .antMatchers("/main/**").permitAll()
//                .antMatchers("/admin/**").permitAll()
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
