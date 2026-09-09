package com.music.builder.domain;

public class Track {
    private final String title;
    private final Genre genre;
    private final int bpm;
    private final boolean isMastered;

    public Track(String title, Genre genre, int bpm, boolean isMastered) {
        this.title = title;
        this.genre = genre;
        this.bpm = bpm;
        this.isMastered = isMastered;
    }

    @Override
    public String toString() {
        return String.format("Трек: '%s' | Жанр: %s | Темп: %d BPM | Мастеринг: %s",
                title, genre, bpm, isMastered ? "ДА" : "НЕТ");
    }
}