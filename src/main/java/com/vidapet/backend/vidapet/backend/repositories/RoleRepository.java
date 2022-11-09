package com.vidapet.backend.vidapet.backend.repositories;

import com.vidapet.backend.vidapet.backend.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
