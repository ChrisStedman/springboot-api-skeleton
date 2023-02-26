package com.example.springapiskeleton.mapper;

import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.model.ArtistDomain;
import com.example.springapiskeleton.model.Genre;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    public ArtistDomain mapToArtistDomain(ArtistBase artistBase) {
        ArtistDomain artist = new ArtistDomain();
        artist.setName(artistBase.getName());
        artist.setGenre(Genre.fromValue(artistBase.getGenre().getValue()));

        return artist;
    }

    public Artist mapToArtist(ArtistDomain artistDomain){
        return new Artist()
                .id(artistDomain.getId())
                .name(artistDomain.getName())
                .genre(
                        com.example.springapiskeleton.api.model.Genre.fromValue(artistDomain.getGenre().getValue())
                )
                .albums(Lists.newArrayList());

    }
}
