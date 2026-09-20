package com.music.builder.director;

import com.music.builder.builders.TrackBuilder;
import com.music.builder.domain.Genre;

public class SoundProducerDirector {

    public void makePluggnbBeat(TrackBuilder builder) {
        builder.reset()
                .setTitle("Pyramids")
                .setArtist("Frank Ocean")
                .setGenre(Genre.alternative)
                .setBpm(117)
                .setRecordingType("Studio Recording")
                .applyMastering();
    }

    public void makeSynthwaveTrack(TrackBuilder builder) {
        builder.reset()
                .setTitle("Cyber Drive 2088")
                .setArtist("Unknown")
                .setGenre(Genre.synthwave)
                .setBpm(128)
                .applyMastering();
    }
}