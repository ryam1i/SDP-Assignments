package com.music.builder.domain;

import java.time.LocalDate;

public class Track {
    private final String title;
    private final String artist;

    public Track(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Track: " + title + " | Artist: " + artist;
    }
}