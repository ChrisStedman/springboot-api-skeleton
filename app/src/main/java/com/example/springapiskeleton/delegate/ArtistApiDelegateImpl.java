package com.example.springapiskeleton.delegate;


import com.example.springapiskeleton.api.ArtistApiDelegate;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.mapper.ArtistMapper;
import com.example.springapiskeleton.model.ArtistDomain;
import com.example.springapiskeleton.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistApiDelegateImpl implements ArtistApiDelegate {

    private final ArtistService artistService;
    private final ArtistMapper artistMapper;

    @Override
    public ResponseEntity<List<Artist>> getArtists() {
        List<ArtistDomain> artists = artistService.getAllArtists();

        List<Artist> responseBody = mapToArtistList(artists);

        return ResponseEntity.ok(responseBody);
    }

    private List<Artist> mapToArtistList(List<ArtistDomain> artistDomains){
        return artistDomains.stream()
                .map(artistMapper::mapToArtist)
                .toList();
    }

    @Override
    public ResponseEntity<Artist> createArtist(ArtistBase artistBase){
        ArtistDomain artist = artistService.createArtist(artistBase);

        Artist responseBody = artistMapper.mapToArtist(artist);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseBody);
    }
}
