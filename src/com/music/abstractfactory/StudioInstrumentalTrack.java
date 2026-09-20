package com.music.abstractfactory;

public class StudioInstrumentalTrack implements InstrumentalTrack{
    @Override
    public void playInstruments() {
        System.out.println("Studio instrumental: ");
    }
}

//concrete product