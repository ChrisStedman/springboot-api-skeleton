package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.dao.AlbumDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final ArtistService artistService;

    @Override
    public Album createAlbum(AlbumBase albumBase) {

        validateArtistExists(albumBase.getArtistId());

        Album album = AlbumDao.createAlbum(albumBase);

        artistService.addAlbumToArtist(album);

        return album;
    }

    private void validateArtistExists(Long id){
        if(!artistService.isExistingArtist(id)){
            throw new NoSuchElementException("No artist found with id " + id);
        }
    }
}
