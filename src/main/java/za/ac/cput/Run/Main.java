package za.ac.cput.Run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.servlet.annotation.WebServlet;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Main
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigurableWebApplicationContext.class);
    }
}
