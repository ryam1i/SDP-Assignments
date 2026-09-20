package com.music.factory;

import com.music.builder.domain.Track;

public class WavAudioExporter implements AudioExporter {
    @Override
    public void export(Track track) {
        System.out.println("Exporting in WAV format: " + track);
    }
}

//concrete product