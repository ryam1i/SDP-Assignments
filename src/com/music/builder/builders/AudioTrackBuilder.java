package com.music.builder.builders;

import com.music.builder.domain.Genre;
import com.music.builder.domain.Track;

import java.time.LocalDate;

public class AudioTrackBuilder implements TrackBuilder {

    private String title;
    private String artist;
    private Genre genre;
    private int bpm;
    private boolean isMastered;
    private LocalDate releaseDate;
    private String recordingType;
    private String productionType;

    @Override
    public AudioTrackBuilder reset() {
        this.title = null;
        this.artist = null;
        this.releaseDate = null;
        this.genre = null;
        this.bpm = 0;
        this.isMastered = false;
        this.recordingType = null;
        this.productionType = null;
        return this;
    }

    @Override
    public AudioTrackBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public AudioTrackBuilder setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    @Override
    public AudioTrackBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public AudioTrackBuilder setBpm(int bpm) {
        this.bpm = bpm;
        return this;
    }

    @Override
    public AudioTrackBuilder applyMastering() {
        this.isMastered = true;
        return this;
    }

    @Override
    public AudioTrackBuilder setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @Override
    public AudioTrackBuilder setRecordingType(String recordingType) {
        this.recordingType = recordingType;
        return this;
    }

    @Override
    public AudioTrackBuilder setProductionType(String productionType) {
        this.productionType = productionType;
        return this;
    }

    public Track build() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Track must contain the name");
        }
        return new Track(title, artist);
    }
}