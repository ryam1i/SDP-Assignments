package com.music.abstractfactory;

public class LiveTrackFactory implements TrackProductionFactory {
    @Override
    public VocalTrack createVocalTrack() {
        return new LiveVocalTrack();
    }
    @Override
    public InstrumentalTrack createInstrumentalTrack() {
        return new LiveInstrumentalTrack();
    }
}

//concrete factory