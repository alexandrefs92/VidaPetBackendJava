package com.vidapet.backend.vidapet.backend.services;

import com.vidapet.backend.vidapet.backend.models.EspecieModel;
import com.vidapet.backend.vidapet.backend.repositories.EspecieRepository;
import com.vidapet.backend.vidapet.backend.services.exceptions.DatabaseException;
import com.vidapet.backend.vidapet.backend.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    @Autowired
    private EspecieRepository repository;

    public List<EspecieModel> findAll() {
        return repository.findAll();
    }

    public EspecieModel findById(Long id) {
        Optional<EspecieModel> obj = repository.findById(id);
        return obj.get();
    }

    public EspecieModel insert(EspecieModel EspecieModel) {
        return repository.save(EspecieModel);
    }

    public EspecieModel update(Long id, EspecieModel obj) {
        try {
            EspecieModel entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(EspecieModel entity, EspecieModel obj) {
        entity.setNome(obj.getNome());
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
    
}
