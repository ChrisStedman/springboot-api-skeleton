package com.example.springapiskeleton.delegate;

import com.example.springapiskeleton.api.AlbumApiDelegate;
import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

    private final AlbumService albumService;

    @Override
    public ResponseEntity<Album> createAlbum(AlbumBase albumBase){
        Album album = albumService.createAlbum(albumBase);

        return ResponseEntity.ok(album);
    }
}
