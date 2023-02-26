package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.model.ArtistDomain;

import java.util.List;

public interface ArtistService {

    List<ArtistDomain> getAllArtists();

    Boolean isExistingArtist(Long id);

    ArtistDomain createArtist(ArtistBase artistBase);

}
