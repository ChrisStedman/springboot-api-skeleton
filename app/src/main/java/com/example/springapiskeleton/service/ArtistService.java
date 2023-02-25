package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;

import java.util.List;

public interface ArtistService {

    List<Artist> getAllArtists();

    Artist createArtist(ArtistBase artistBase);
}
