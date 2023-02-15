package com.example.springapiskeleton.delegate;


import com.example.springapiskeleton.api.ArtistApiDelegate;
import com.example.springapiskeleton.api.model.Artist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistApiDelegateImpl implements ArtistApiDelegate {

    @Override
    public ResponseEntity<List<Artist>> getArtists() {
        List<Artist> response = List.of(new Artist());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Artist> createArtist(Artist artist){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(artist);
    }
}
