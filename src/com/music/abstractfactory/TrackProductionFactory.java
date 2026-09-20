package com.music.abstractfactory;

public interface TrackProductionFactory {
    VocalTrack createVocalTrack();
    InstrumentalTrack createInstrumentalTrack();
}
