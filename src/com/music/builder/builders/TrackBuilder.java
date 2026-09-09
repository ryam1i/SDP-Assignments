package com.music.builder.builders;

import com.music.builder.domain.Genre;

public interface TrackBuilder {
    TrackBuilder reset();
    TrackBuilder setTitle(String title);
    TrackBuilder setGenre(Genre genre);
    TrackBuilder setBpm(int bpm);
    TrackBuilder applyMastering();
}