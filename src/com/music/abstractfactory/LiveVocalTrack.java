package com.music.abstractfactory;

public class LiveVocalTrack implements VocalTrack {
    @Override
    public void recordVocals() {
        System.out.println("Live vocal record: ");
    }
}
