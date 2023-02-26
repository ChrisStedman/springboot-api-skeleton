package com.example.springapiskeleton.mapper;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.model.AlbumDomain;
import com.example.springapiskeleton.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class AlbumMapper {

    public AlbumDomain mapToAlbumDomain(AlbumBase albumBase){
        AlbumDomain album = new AlbumDomain();
        album.setName(albumBase.getName());
        album.setGenre(Genre.fromValue(albumBase.getGenre().getValue()));
        album.setReleaseDate(albumBase.getReleaseDate());
        album.setArtistId(albumBase.getArtistId());

        return album;
    }

    public Album mapToAlbum(AlbumDomain albumDomain){
        return new Album()
                .id(albumDomain.getId())
                .name(albumDomain.getName())
                .genre(
                        com.example.springapiskeleton.api.model.Genre.fromValue(albumDomain.getGenre().getValue())
                )
                .releaseDate(albumDomain.getReleaseDate())
                .artistId(albumDomain.getArtistId());
    }
}
