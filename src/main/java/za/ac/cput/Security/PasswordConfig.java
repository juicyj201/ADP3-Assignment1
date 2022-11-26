package za.ac.cput.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
    /**
     * @method passwordEncoder
     * -----------------------
     * This returns a password encoder (scrambler) for user
     * security purposes. It is used only by the webconfig methods.
     *
     * @return - returns a password encoder object
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
