package com.music.builder.builders;

import com.music.builder.domain.Genre;
import com.music.builder.domain.TrackReleaseManifest;

public class TrackManifestBuilder implements TrackBuilder {
    private StringBuilder text = new StringBuilder();

    @Override
    public TrackManifestBuilder reset() {
        this.text = new StringBuilder();
        return this;
    }

    @Override
    public TrackManifestBuilder setTitle(String title) {
        text.append("• Название: ").append(title).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setGenre(Genre genre) {
        text.append("• Жанр: ").append(genre).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder setBpm(int bpm) {
        text.append("• BPM: ").append(bpm).append("\n");
        return this;
    }

    @Override
    public TrackManifestBuilder applyMastering() {
        text.append("• Мастеринг: Готов к публикации (-14 LUFS)\n");
        return this;
    }

    public TrackReleaseManifest build() {
        return new TrackReleaseManifest(text.toString());
    }
}