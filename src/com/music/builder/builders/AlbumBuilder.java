package com.music.builder.builders;

public interface AlbumBuilder {
    AlbumBuilder reset();
    AlbumBuilder setTitle(String title);
    AlbumBuilder setArtist(String artist);
    AlbumBuilder setGenre(String genre);
    AlbumBuilder setReleaseDate(String releaseDate);
    AlbumBuilder setRecordingType(String recordingType);
    AlbumBuilder setProductionType(String productionType);
}
