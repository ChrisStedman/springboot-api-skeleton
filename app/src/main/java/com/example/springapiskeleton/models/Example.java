package com.example.springapiskeleton.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity(name = "Example")
@Table(name = "example_table")
public class Example {
    @Id
    @SequenceGenerator(name = "example_sequence", sequenceName = "example_sequence", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "example_sequence")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private OffsetDateTime createdAt;
}
