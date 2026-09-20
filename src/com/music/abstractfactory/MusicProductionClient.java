package com.music.abstractfactory;

public class MusicProductionClient {
    private final VocalTrack vocalTrack;
    private final InstrumentalTrack instrumentalTrack;

    public MusicProductionClient(TrackProductionFactory factory) {
        this.vocalTrack = factory.createVocalTrack();
        this.instrumentalTrack = factory.createInstrumentalTrack();
    }

    public void producePerformance() {
        instrumentalTrack.playInstruments();
        vocalTrack.recordVocals();
    }
}

//client class
