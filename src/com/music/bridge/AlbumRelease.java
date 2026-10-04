package com.music.bridge;

public class AlbumRelease extends MusicRelease {
    
    private int trackCount;

    public AlbumRelease(StreamingPlatformGateway gateway, String title, String artist, String upcOrIsrc, int trackCount) {
        super(gateway, title, upcOrIsrc);
        this.trackCount = trackCount;
    }
    
    @Override
    public void publishRelease() {
        System.out.println("[Album Release] Initiating distribution for album: '" + title + "'");
        gateway.authenticate();
        gateway.uploadAudioMetadata(title, upcOrIsrc, trackCount);
    }
}
