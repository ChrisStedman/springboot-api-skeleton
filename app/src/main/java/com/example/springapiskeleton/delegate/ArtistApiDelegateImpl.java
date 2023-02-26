package com.example.springapiskeleton.delegate;


import com.example.springapiskeleton.api.ArtistApiDelegate;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
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

    @Override
    public ResponseEntity<List<Artist>> getArtists() {
        List<Artist> artists = artistService.getAllArtists();

        return ResponseEntity.ok(artists);
    }

    @Override
    public ResponseEntity<Artist> createArtist(ArtistBase artistBase){
        Artist artist = artistService.createArtist(artistBase);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(artist);
    }
}
