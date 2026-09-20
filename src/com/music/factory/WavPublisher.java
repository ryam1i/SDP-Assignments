package com.music.factory;

public class WavPublisher extends AudioPublisher {
    @Override
    public AudioExporter createExporter() {
        return new WavAudioExporter();
    }
}

//concrete creatorr