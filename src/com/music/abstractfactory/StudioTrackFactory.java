package com.music.abstractfactory;

public class StudioTrackFactory implements TrackProductionFactory {
    @Override
    public VocalTrack createVocalTrack() {
        return new StudioVocalTrack();
    }
    @Override
    public InstrumentalTrack createInstrumentalTrack() {
        return new StudioInstrumentalTrack();
    }
}

//concrete factory