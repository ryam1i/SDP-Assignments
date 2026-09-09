import com.music.builder.builders.AudioTrackBuilder;
import com.music.builder.builders.TrackManifestBuilder;
import com.music.builder.director.SoundProducerDirector;
import com.music.builder.domain.Genre;
import com.music.builder.domain.Track;
import com.music.builder.domain.TrackReleaseManifest;

public class Main {
    public static void main(String[] args) {
        SoundProducerDirector director = new SoundProducerDirector();


        AudioTrackBuilder audioBuilder = new AudioTrackBuilder();
        director.makeLoFiBeat(audioBuilder);
        Track track = audioBuilder.build();
        System.out.println(track);


        TrackManifestBuilder manifestBuilder = new TrackManifestBuilder();
        director.makeLoFiBeat(manifestBuilder);
        TrackReleaseManifest manifest = manifestBuilder.build();
        System.out.println(manifest);


        Track customTrack = new AudioTrackBuilder()
                .setTitle("Garage Rock Live")
                .setGenre(Genre.ROCK)
                .setBpm(140)
                .build();
        System.out.println(customTrack);

        TrackReleaseManifest rockManifest = new TrackManifestBuilder()
                .setTitle("Garage Rock Live")
                .setGenre(Genre.ROCK)
                .setBpm(140)
                .build();
        System.out.println(rockManifest);

        try {
            new AudioTrackBuilder().setBpm(120).build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}