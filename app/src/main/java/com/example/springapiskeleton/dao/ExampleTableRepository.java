package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.models.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleTableRepository extends JpaRepository<Example, Integer> {
}
