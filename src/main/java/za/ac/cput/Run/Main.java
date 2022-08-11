package za.ac.cput.Run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Repository.AdminRepository;

import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The Spring Boot Application
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Main
{
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main( String[] args )
    {
        SpringApplication.run(Main.class);
    }

    /**
    @Bean
    public CommandLineRunner runner(AdminRepository repo){
        return (args) -> {
            //save
            AdminFactory fact = new AdminFactory();
            repo.save(fact.buildAdmin("21", "Manager", "John", "Banks"));
            repo.save(fact.buildAdmin("54", "Manager", "Goros", "Maximus"));

            //read
            log.info("Read all admin(s):");
            log.info("------------------");
            for(Admin admin : repo.findAll()){
                log.info(admin.toString());
            }

            //find
            log.info("Find admin by Id:");
            log.info("-----------------");
            Optional<Admin> foundAdmin = repo.findById("21");
            if(foundAdmin != null){
                log.info(foundAdmin.toString());
            }
        };
    }

    **/
}
