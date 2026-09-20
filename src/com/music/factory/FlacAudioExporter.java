package com.music.factory;

import com.music.builder.domain.Track;

public class FlacAudioExporter implements AudioExporter {
    @Override
    public void export(Track track) {
        System.out.println("Exporting in lossless FLAC: " + track);
    }
}

//concrete product
