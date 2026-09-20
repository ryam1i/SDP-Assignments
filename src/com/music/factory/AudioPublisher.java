package com.music.factory;

import com.music.builder.domain.Track;

public abstract class AudioPublisher {

    public abstract AudioExporter createExporter();

    public void publish(Track track) {
        AudioExporter exporter = createExporter();
        System.out.println("Preparing for release publishing: " + track);
        exporter.export(track);
        System.out.println("Done!");
    }
}

//creator
