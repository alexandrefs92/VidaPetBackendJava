package com.vidapet.backend.vidapet.backend.services;

import com.vidapet.backend.vidapet.backend.models.UserModel;
import com.vidapet.backend.vidapet.backend.repositories.UserRepository;
import com.vidapet.backend.vidapet.backend.services.exceptions.DatabaseException;
import com.vidapet.backend.vidapet.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService, Serializable {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findById(Long id) {
        Optional<UserModel> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow( () -> new ResolutionException(username));
    }

    public UserModel insert(UserModel obj) { return userRepository.save(obj); }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserModel update(Long id, UserModel obj) {
        try {
            UserModel entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(UserModel entity, UserModel obj) {
        entity.setEmail(obj.getEmail());
        entity.setUsername(obj.getUsername());
    }
}
