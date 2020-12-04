package com.DA.RiaProject.security;

import com.DA.RiaProject.DAO.UserRepository;
import com.DA.RiaProject.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNickname(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with name %s not exists.", username)));
        return new UserPrincipal(user);
    }
}
