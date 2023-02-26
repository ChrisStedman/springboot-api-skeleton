package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.dao.AlbumRepository;
import com.example.springapiskeleton.mapper.AlbumMapper;
import com.example.springapiskeleton.model.AlbumDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public AlbumDomain createAlbum(AlbumBase albumBase) {

        AlbumDomain albumDomain = albumMapper.mapToAlbumDomain(albumBase);

        return albumRepository.saveAndFlush(albumDomain);
    }
}
