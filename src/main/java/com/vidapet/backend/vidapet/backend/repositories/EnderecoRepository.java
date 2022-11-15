package com.vidapet.backend.vidapet.backend.repositories;

import com.vidapet.backend.vidapet.backend.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long> {
}
