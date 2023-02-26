package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.model.AlbumDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumDomain, Long> {
}
