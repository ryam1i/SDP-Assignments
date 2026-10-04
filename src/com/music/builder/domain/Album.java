package com.music.builder.domain;

public class Album {
    private final String title;
    private final String artist;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album: " + title + " | Artist: " + artist + "";
    }
}
