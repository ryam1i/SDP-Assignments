package com.music.builder.builders;

import com.music.builder.domain.AlbumReleaseManifest;

public class AlbumManifestBuilder implements AlbumBuilder {
    private StringBuilder text = new StringBuilder();

    @Override
    public AlbumManifestBuilder reset() {
        this.text = new StringBuilder();
        return this;
    }

    @Override
    public AlbumManifestBuilder setTitle(String title) {
        text.append("Album Title: ").append(title).append("\n");
        return this;
    }

    @Override
    public AlbumManifestBuilder setArtist(String artist) {
        text.append("Artist: ").append(artist).append("\n");
        return this;
    }

    @Override
    public AlbumManifestBuilder setGenre(String genre) {
        text.append("Genre: ").append(genre).append("\n");
        return this;
    }

    @Override
    public AlbumManifestBuilder setReleaseDate(String releaseDate) {
        text.append("Release date: ").append(releaseDate).append("\n");
        return this;
    }

    @Override
    public AlbumManifestBuilder setRecordingType(String recordingType) {
        text.append("Recording: ").append(recordingType).append("\n");
        return this;
    }

    @Override
    public AlbumManifestBuilder setProductionType(String productionType) {
        text.append("Production: ").append(productionType).append("\n");
        return this;
    }

    public AlbumReleaseManifest build() {
        return new AlbumReleaseManifest(text.toString());
    }
}
