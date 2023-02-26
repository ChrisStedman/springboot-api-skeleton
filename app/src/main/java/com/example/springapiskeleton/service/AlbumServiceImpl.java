package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.dao.AlbumRepository;
import com.example.springapiskeleton.mapper.AlbumMapper;
import com.example.springapiskeleton.model.AlbumDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public AlbumDomain getAlbumById(String albumId){
        Optional<AlbumDomain> album = albumRepository.findById(Long.parseLong(albumId));

        return album.orElseThrow(
                () -> new NoSuchElementException("No album found with id " + albumId)
        );
    }

    @Override
    public AlbumDomain createAlbum(AlbumBase albumBase) {

        AlbumDomain albumDomain = albumMapper.mapToAlbumDomain(albumBase);

        return albumRepository.saveAndFlush(albumDomain);
    }
}
