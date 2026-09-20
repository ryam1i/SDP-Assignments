package com.music.abstractfactory;

public class LiveInstrumentalTrack implements InstrumentalTrack {
    @Override
    public void playInstruments() {
        System.out.println("Live Instrumental: ");
    }
}
