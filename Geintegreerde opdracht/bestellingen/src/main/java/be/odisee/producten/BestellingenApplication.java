package be.odisee.producten;

import be.odisee.producten.DAO.BestellingRepository;
import be.odisee.producten.DAO.BestellingLijnRepository;
import be.odisee.producten.domain.Bestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled=true)
public class BestellingenApplication extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(BestellingenApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BestellingRepository repo, BestellingLijnRepository repo2) {
        return (evt) -> {
            repo.save(new Bestelling(1, "broodjes"));
            repo.save(new Bestelling(2, "snacks"));
        };
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // ...
                .csrf().disable();
    }





}
