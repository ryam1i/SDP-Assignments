package com.music.builder.builders;

import com.music.builder.domain.Genre;
import com.music.builder.domain.Track;

public class AudioTrackBuilder implements TrackBuilder {
    private static final int MIN_BPM = 40;
    private static final int MAX_BPM = 240;

    private String title;
    private Genre genre;
    private int bpm;
    private boolean isMastered;

    @Override
    public AudioTrackBuilder reset() {
        this.title = null;
        this.genre = null;
        this.bpm = 0;
        this.isMastered = false;
        return this;
    }

    @Override
    public AudioTrackBuilder setTitle(String title) {
        this.title = title;
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

    public Track build() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Ошибка: у трека должно быть название!");
        }
        if (bpm < MIN_BPM || bpm > MAX_BPM) {
            throw new IllegalStateException("Ошибка: недопустимый BPM (" + bpm + ")");
        }
        return new Track(title, genre, bpm, isMastered);
    }
}