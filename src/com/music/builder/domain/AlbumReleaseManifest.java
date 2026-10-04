package com.music.builder.domain;

public class AlbumReleaseManifest {
    private final String text;

    public AlbumReleaseManifest(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
