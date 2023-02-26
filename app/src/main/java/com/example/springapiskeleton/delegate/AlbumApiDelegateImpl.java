package com.example.springapiskeleton.delegate;

import com.example.springapiskeleton.api.AlbumApiDelegate;
import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.mapper.AlbumMapper;
import com.example.springapiskeleton.model.AlbumDomain;
import com.example.springapiskeleton.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

    private final AlbumService albumService;
    private final AlbumMapper albumMapper;

    @Override
    public ResponseEntity<Album> createAlbum(AlbumBase albumBase){
        AlbumDomain album = albumService.createAlbum(albumBase);

        Album responseBody = albumMapper.mapToAlbum(album);

        return ResponseEntity.ok(responseBody);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(String albumId) {
        AlbumDomain album = albumService.getAlbumById(albumId);

        Album responseBody = albumMapper.mapToAlbum(album);

        return ResponseEntity.ok(responseBody);
    }
}
