package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.dao.ArtistDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Override
    public List<Artist> getAllArtists() {
        return ArtistDao.getArtistList();
    }

    @Override
    public Boolean isExistingArtist(Long id){
        Optional<Artist> artist = ArtistDao.getArtistById(id);

        return artist.isPresent();
    }

    @Override
    public Artist createArtist(ArtistBase artistBase){
        return ArtistDao.createArtist(artistBase);
    }

    @Override
    public void addAlbumToArtist(Album album){
        ArtistDao.addAlbumToArtist(album);
    }

}
