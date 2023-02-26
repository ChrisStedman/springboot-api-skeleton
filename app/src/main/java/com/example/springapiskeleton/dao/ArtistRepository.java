package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.model.ArtistDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistDomain, Long> {
}
