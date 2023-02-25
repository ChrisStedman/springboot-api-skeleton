package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.Album;
import com.example.springapiskeleton.api.model.AlbumBase;

public interface AlbumService {

    Album createAlbum(AlbumBase albumBase);
}
