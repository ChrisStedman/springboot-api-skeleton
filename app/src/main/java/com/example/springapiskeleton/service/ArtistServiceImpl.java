package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Artist;
import com.example.springapiskeleton.api.model.ArtistBase;
import com.example.springapiskeleton.dao.ArtistDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Override
    public List<Artist> getAllArtists() {
        return ArtistDao.getArtistList();
    }

    @Override
    public Artist createArtist(ArtistBase artistBase){
        return ArtistDao.createArtist(artistBase);
    }

}
