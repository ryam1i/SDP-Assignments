package com.music.builder.builders;

import com.music.builder.domain.Album;

public class AudioAlbumBuilder implements AlbumBuilder {
    private String title;
    private String artist;
    private String genre;
    private String releaseDate;
    private String recordingType;
    private String productionType;

    @Override
    public AudioAlbumBuilder reset() {
        this.title = null;
        this.artist = null;
        this.genre = null;
        this.releaseDate = null;
        this.recordingType = null;
        this.productionType = null;
        return this;
    }

    @Override
    public AudioAlbumBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public AudioAlbumBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    @Override
    public AudioAlbumBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public AudioAlbumBuilder setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Override
    public AudioAlbumBuilder setRecordingType(String recordingType) {
        this.recordingType = recordingType;
        return this;
    }

    @Override
    public AudioAlbumBuilder setProductionType(String productionType) {
        this.productionType = productionType;
        return this;
    }

    public Album build() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Album must contain the name");
        }
        return new Album(title, artist);
    }
}