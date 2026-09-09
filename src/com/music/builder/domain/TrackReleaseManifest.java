package com.music.builder.domain;

public class TrackReleaseManifest {
    private final String text;

    public TrackReleaseManifest(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Манифест релиза:\n" + text;
    }
}