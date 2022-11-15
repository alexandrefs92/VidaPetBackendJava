package com.vidapet.backend.vidapet.backend.services;

import com.vidapet.backend.vidapet.backend.models.RacaModel;
import com.vidapet.backend.vidapet.backend.repositories.RacaRepository;
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
public class RacaService {

    @Autowired
    private RacaRepository repository;

    public List<RacaModel> findAll() {
        return repository.findAll();
    }

    public RacaModel findById(Long id) {
        Optional<RacaModel> obj = repository.findById(id);
        return obj.get();
    }

    public RacaModel insert(RacaModel RacaModel) {
        return repository.save(RacaModel);
    }

    public RacaModel update(Long id, RacaModel obj) {
        try {
            RacaModel entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(RacaModel entity, RacaModel obj) {
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
