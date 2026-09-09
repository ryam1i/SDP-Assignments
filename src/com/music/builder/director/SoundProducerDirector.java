package com.music.builder.director;

import com.music.builder.builders.TrackBuilder;
import com.music.builder.domain.Genre;

public class SoundProducerDirector {

    public void makeLoFiBeat(TrackBuilder builder) {
        builder.reset()
                .setTitle("Coffee & Coding")
                .setGenre(Genre.LO_FI)
                .setBpm(80)
                .applyMastering();
    }

    public void makeSynthwaveTrack(TrackBuilder builder) {
        builder.reset()
                .setTitle("Cyber Drive 2088")
                .setGenre(Genre.SYNTHWAVE)
                .setBpm(128)
                .applyMastering();
    }
}