package com.lsd.logement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsd.logement.entity.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {

    Optional<Media> findByRef(String ref);

   
}
