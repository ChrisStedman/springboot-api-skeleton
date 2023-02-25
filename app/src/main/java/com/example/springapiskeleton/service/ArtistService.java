package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;

import java.util.List;

public interface ArtistService {

    List<Artist> getAllArtists();

    Boolean isExistingArtist(Long id);

    Artist createArtist(ArtistBase artistBase);

    void addAlbumToArtist(Album album);
}
