package com.vidapet.backend.vidapet.backend.security;

import com.vidapet.backend.vidapet.backend.models.UserModel;
import com.vidapet.backend.vidapet.backend.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel user = userRepository.findByUsername(username).orElseThrow( ()  -> new UsernameNotFoundException("Usuário não encontrado: " + username));
            return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
