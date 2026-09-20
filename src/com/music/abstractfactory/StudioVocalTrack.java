package com.music.abstractfactory;

public class StudioVocalTrack implements VocalTrack {
    @Override
    public void recordVocals() {
        System.out.println("Studio recording: ");
    }
}

//concrete product