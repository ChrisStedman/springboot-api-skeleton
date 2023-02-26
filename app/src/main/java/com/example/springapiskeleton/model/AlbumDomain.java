package com.example.springapiskeleton.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.OffsetDateTime;


@Entity(name = "Album")
@Table(name = "album")
@Getter
@Setter
public class AlbumDomain {

    @Id
    @SequenceGenerator(name = "album_sequence", sequenceName = "album_sequence", allocationSize = 1)
    @GeneratedValue(generator = "album_sequence")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "artist_id", insertable = false, updatable = false)
    private ArtistDomain artist;

    @Column(name = "artist_id")
    private Long artistId;

    @Column
    private LocalDate releaseDate;

    @Column(nullable = false)
    @CreationTimestamp
    private OffsetDateTime creationDate;
}
