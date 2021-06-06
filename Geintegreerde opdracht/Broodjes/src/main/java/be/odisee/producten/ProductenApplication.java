package be.odisee.producten;

import be.odisee.producten.DAO.CategoryRepository;
import be.odisee.producten.domain.Category;
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
public class ProductenApplication extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(ProductenApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CategoryRepository repo) {
        return (evt) -> {
            repo.save(new Category(1, "broodjes"));
            repo.save(new Category(2, "snacks"));
            repo.save(new Category(3, "desserten"));
            repo.save(new Category(4, "drinken"));
            repo.save(new Category(5, "menu's"));
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
                .csrf().disable()
                //zet alles hieronder in comment om security uit te zetten
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }





}
