package be.odisee.ti2.se4.jaegher.service;

import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import be.odisee.ti2.se4.jaegher.DAO.GebruikerRepository;
import be.odisee.ti2.se4.jaegher.domain.Gebruiker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Primary  // if there would be any confusion with InMemory implementation, this one should be chosen
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private GebruikerRepository gebruikerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Gebruiker gebruiker = gebruikerRepository.findByUsername(username);
        if (gebruiker != null) return gebruiker;
        throw new UsernameNotFoundException("User "+username+" not found!");
    }
}
