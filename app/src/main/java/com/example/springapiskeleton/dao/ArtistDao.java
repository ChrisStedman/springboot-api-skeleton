package com.example.springapiskeleton.dao;

import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.api.model.Genre;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

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
                .albums(List.of());
    }

    public static Artist createArtist(ArtistBase artistBase){
        Artist artist = buildArtist(id++, artistBase.getName(), artistBase.getGenre());

        artistList.add(artist);

        return artist;
    }

}
