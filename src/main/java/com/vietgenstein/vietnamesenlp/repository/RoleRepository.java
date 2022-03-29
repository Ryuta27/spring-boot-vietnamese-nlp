package com.vietgenstein.vietnamesenlp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vietgenstein.vietnamesenlp.models.ERole;
import com.vietgenstein.vietnamesenlp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
