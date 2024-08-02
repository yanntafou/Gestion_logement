package com.lsd.logement.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.personnel.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByUsername(String username);

    Optional<AppUser> findByEmail(String email);

    public boolean existsByRoles(String role_admin);

    public Page<AppUser> findAllByRolesIsNot(String role, Pageable pageable);

}
