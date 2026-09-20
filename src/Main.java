import com.music.builder.builders.AudioTrackBuilder;
import com.music.builder.builders.TrackManifestBuilder;
import com.music.builder.director.SoundProducerDirector;
import com.music.builder.domain.Genre;
import com.music.builder.domain.Track;
import com.music.builder.domain.TrackReleaseManifest;
import com.music.factory.AudioPublisher;
import com.music.factory.FlacPublisher;
import com.music.factory.WavPublisher;
import com.music.abstractfactory.LiveTrackFactory;
import com.music.abstractfactory.MusicProductionClient;
import com.music.abstractfactory.StudioTrackFactory;
import com.music.abstractfactory.TrackProductionFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SoundProducerDirector director = new SoundProducerDirector();


        AudioTrackBuilder audioBuilder = new AudioTrackBuilder();
        director.makePluggnbBeat(audioBuilder);
        Track track = audioBuilder.build();
        System.out.println(track);


        TrackManifestBuilder manifestBuilder = new TrackManifestBuilder();
        director.makePluggnbBeat(manifestBuilder);
        TrackReleaseManifest manifest = manifestBuilder.build();
        System.out.println(manifest);


        AudioPublisher flacPublisher = new FlacPublisher();
        AudioPublisher wavPublisher = new WavPublisher();


        wavPublisher.publish(track);
        System.out.println();


        Track customTrack = new AudioTrackBuilder()
                .setTitle("Die For You - Live")
                .setArtist("The Weeknd")
                .build();
        System.out.println(customTrack);

        TrackReleaseManifest rnbManifest = new TrackManifestBuilder()
                .setTitle("Die For You")
                .setArtist("The Weeknd")
                .setRecordingType("Live Performance")
                .setGenre(Genre.rnb)
                .setBpm(67)
                .setReleaseDate(LocalDate.of(2016, 11, 24))
                .build();
        System.out.println(rnbManifest);


        flacPublisher.publish(customTrack);
        System.out.println();


        try {
            new AudioTrackBuilder().setBpm(120).build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}