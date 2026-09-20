package com.music.builder.builders;

import com.music.builder.domain.Genre;

import java.time.LocalDate;

public interface TrackBuilder {
    TrackBuilder reset();
    TrackBuilder setTitle(String title);
    TrackBuilder setArtist(String artist);
    TrackBuilder setGenre(Genre genre);
    TrackBuilder setBpm(int bpm);
    TrackBuilder applyMastering();
    TrackBuilder setReleaseDate(LocalDate releaseDate);
    TrackBuilder setRecordingType(String recordingType);
}