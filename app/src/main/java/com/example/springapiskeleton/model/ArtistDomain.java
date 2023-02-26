package com.example.springapiskeleton.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;

@Entity(name = "Artist")
@Table(name = "artist")
@Getter
@Setter
public class ArtistDomain {
    @Id
    @SequenceGenerator(name = "artist_sequence", sequenceName = "artist_sequence", allocationSize = 1)
    @GeneratedValue(generator = "artist_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private List<AlbumDomain> albums = Lists.newArrayList();

    @Column(nullable = false)
    @CreationTimestamp
    private OffsetDateTime creationDate;
}