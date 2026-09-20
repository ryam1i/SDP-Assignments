package com.music.factory;

public class FlacPublisher extends AudioPublisher {
    @Override
    public AudioExporter createExporter() {
        return new FlacAudioExporter();
    }
}

//concrete creator
