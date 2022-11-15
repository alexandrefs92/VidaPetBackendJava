package com.vidapet.backend.vidapet.backend.repositories;

import com.vidapet.backend.vidapet.backend.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
