package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.dao.ArtistRepository;
import com.example.springapiskeleton.mapper.ArtistMapper;
import com.example.springapiskeleton.model.ArtistDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    @Override
    public List<ArtistDomain> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Boolean isExistingArtist(Long id){
        Optional<ArtistDomain> artist = artistRepository.findById(id);

        return artist.isPresent();
    }

    @Override
    public ArtistDomain createArtist(ArtistBase artistBase){
        ArtistDomain artist = artistMapper.mapToArtistDomain(artistBase);

        return artistRepository.saveAndFlush(artist);
    }

}
