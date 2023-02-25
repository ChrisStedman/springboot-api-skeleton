package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

public class AlbumDao {

    private static Long id = 1L;

    @Getter
    private static final List<Album> albumList;

    static {
        albumList = Lists.newArrayList();
    }

    private static Album buildAlbum(AlbumBase albumBase){
        return new Album()
                .id(id++)
                .name(albumBase.getName())
                .genre(albumBase.getGenre())
                .artistId(albumBase.getArtistId())
                .releaseDate(albumBase.getReleaseDate());
    }

    public static Album createAlbum(AlbumBase albumBase){
        Album album = buildAlbum(albumBase);

        albumList.add(album);

        return album;
    }
}
