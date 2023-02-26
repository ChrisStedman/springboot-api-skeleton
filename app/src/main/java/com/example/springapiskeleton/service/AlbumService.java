package com.example.springapiskeleton.service;

import com.example.springapiskeleton.api.model.AlbumBase;
import com.example.springapiskeleton.model.AlbumDomain;

public interface AlbumService {

    AlbumDomain createAlbum(AlbumBase albumBase);
}
