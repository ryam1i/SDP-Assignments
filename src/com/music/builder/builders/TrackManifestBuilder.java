package com.music.builder.builders;

import com.music.builder.domain.Genre;
import com.music.builder.domain.TrackReleaseManifest;

import java.time.LocalDate;

public class TrackManifestBuilder implements TrackBuilder {
    private StringBuilder text = new StringBuilder();

    @Override
    public TrackManifestBuilder reset() {
        this.text = new StringBuilder();
        return this;
    }

    @Override
    public TrackManifestBuilder setTitle(String title) {
        text.append("Release Title: ").append(title).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setArtist(String artist) {
        text.append("Artist: ").append(artist).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setGenre(Genre genre) {
        text.append("Genre: ").append(genre).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setBpm(int bpm) {
        text.append("BPM: ").append(bpm).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder applyMastering() {
        text.append("Ready for distributing (-14 LUFS)\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setReleaseDate(LocalDate releaseDate) {
        text.append("Release date: ").append(releaseDate).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setRecordingType(String recordingType) {
        text.append("Recording: ").append(recordingType).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setProductionType(String productionType) {
        text.append("Production: ").append(productionType).append("\n");
        return this;
    }

    public TrackReleaseManifest build() {
        return new TrackReleaseManifest(text.toString());
    }
}