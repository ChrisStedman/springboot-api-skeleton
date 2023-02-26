package com.example.springapiskeleton.mapper;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.model.AlbumDomain;
import com.example.springapiskeleton.model.ArtistDomain;
import com.example.springapiskeleton.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArtistMapper {

    private final AlbumMapper albumMapper;

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
                .albums(mapAlbums(artistDomain.getAlbums()));

    }

    private List<Album> mapAlbums(List<AlbumDomain> albums){
        return albums.stream()
                .map(albumMapper::mapToAlbum)
                .toList();
    }
}
