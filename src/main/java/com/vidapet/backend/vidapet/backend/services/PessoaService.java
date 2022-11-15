package com.vidapet.backend.vidapet.backend.services;

import com.vidapet.backend.vidapet.backend.models.PessoaModel;
import com.vidapet.backend.vidapet.backend.repositories.PessoaRepository;
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
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaModel> findAll() {
        return repository.findAll();
    }

    public PessoaModel findById(Long id) {
        Optional<PessoaModel> obj = repository.findById(id);
        return obj.get();
    }

    public PessoaModel insert(PessoaModel pessoaModel) {
        return repository.save(pessoaModel);
    }

    public PessoaModel update(Long id, PessoaModel obj) {
        try {
            PessoaModel entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(PessoaModel entity, PessoaModel obj) {
        entity.setEmail(obj.getEmail());
        entity.setDataNascimento(obj.getDataNascimento());
        entity.setEndereco(obj.getEndereco());
        entity.setNome(obj.getNome());
        entity.setTipoPessoa(obj.getTipoPessoa());
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
