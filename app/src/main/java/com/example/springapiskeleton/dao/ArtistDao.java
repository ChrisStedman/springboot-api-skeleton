package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.api.model.Genre;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ArtistDao {

    private static Long id = 1L;

    @Getter
    private static final List<Artist> artistList;

    static {
        artistList = buildArtistList();
    }
    private static List<Artist> buildArtistList(){
        return Lists.newArrayList(
                buildArtist(id++, "Nirvana", Genre.GRUNGE),
                buildArtist(id++, "1000mods", Genre.ROCK),
                buildArtist(id++, "Days N Daze", Genre.PUNK)
        );
    }

    private static Artist buildArtist(Long id, String name, Genre genre){
        return new Artist()
                .id(id)
                .name(name)
                .genre(genre)
                .albums(Lists.newArrayList());
    }

    public static Optional<Artist> getArtistById(Long id){
        return getArtistList().stream()
                .filter(artist -> id.equals(artist.getId()))
                .findFirst();
    }

    public static Artist createArtist(ArtistBase artistBase){
        Artist artist = buildArtist(id++, artistBase.getName(), artistBase.getGenre());

        getArtistList().add(artist);

        return artist;
    }

    public static void addAlbumToArtist(Album album){
        Optional<Artist> artist = getArtistById(album.getArtistId());

        artist.orElseThrow(() -> new NoSuchElementException("No artist found with id " + id));

        addAlbum(artist.get(), album);
    }

    private static void addAlbum(Artist artist, Album album){
        artist.getAlbums().add(album);
    }

}
