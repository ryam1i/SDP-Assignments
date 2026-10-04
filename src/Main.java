import com.music.builder.builders.AudioTrackBuilder;
import com.music.builder.builders.TrackManifestBuilder;
import com.music.builder.director.SoundProducerDirector;
import com.music.builder.domain.Genre;
import com.music.builder.domain.Track;
import com.music.builder.domain.TrackReleaseManifest;
import com.music.factory.AudioPublisher;
import com.music.factory.FlacPublisher;
import com.music.factory.WavPublisher;
import com.music.builder.builders.AlbumManifestBuilder;
import com.music.builder.domain.AlbumReleaseManifest;
import com.music.bridge.AlbumRelease;
import com.music.bridge.AppleMusicGateway;
import com.music.bridge.MusicRelease;
import com.music.bridge.SpotifyGateway;
import com.music.bridge.StreamingPlatformGateway;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        
        SoundProducerDirector director = new SoundProducerDirector();


        AudioTrackBuilder audioBuilder = new AudioTrackBuilder();
        director.makePyramids(audioBuilder);
        Track track = audioBuilder.build();
        System.out.println(track);


        TrackManifestBuilder manifestBuilder = new TrackManifestBuilder();
        director.makePyramids(manifestBuilder);
        manifestBuilder.setProductionType("Studio DAW recording");
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


        TrackReleaseManifest customTrackManifest = new TrackManifestBuilder()
                .setTitle("Die For You")
                .setArtist("The Weeknd")
                .setRecordingType("Live Performance")
                .setProductionType("Live at So-Fi Stadium")
                .setGenre(Genre.rnb)
                .setBpm(67)
                .setReleaseDate(LocalDate.of(2016, 11, 24))
                .build();
        System.out.println(customTrackManifest);


        flacPublisher.publish(customTrack);
        System.out.println();


         AlbumReleaseManifest albumManifest = new AlbumManifestBuilder()
            .setTitle("White Pony")
            .setArtist("Deftones")
            .setGenre("Alternative Metal")
            .setReleaseDate("2000-06-20")
            .setRecordingType("Studio")
            .setProductionType("Studio DAW recording")
            .build();
        System.out.println(albumManifest);


        StreamingPlatformGateway spotify = new SpotifyGateway();
        StreamingPlatformGateway appleMusic = new AppleMusicGateway();

        MusicRelease albumRelease = new AlbumRelease(spotify, "White Pony", "Deftones", "UPC-093624734827", 12);
        albumRelease.publishRelease();
        System.out.println();
        albumRelease.setGateway(appleMusic);
        albumRelease.publishRelease();
        System.out.println();


        try {
            new AudioTrackBuilder().setBpm(120).build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}