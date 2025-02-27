package com.org.sfors.serviceImp;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.sfors.entity.UtilisateurEntity;
import com.org.sfors.mapper.Mapper;
import com.org.sfors.repository.UtilisateurRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(JwtUserDetailsService.class);

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UtilisateurEntity> findByEmail = utilisateurRepository.findByEmail(username);
        if (findByEmail.isPresent()) {
            logger.info("user found {}", findByEmail.get().getPassword());
            return (Mapper.toUserDetails(findByEmail.get()));
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
