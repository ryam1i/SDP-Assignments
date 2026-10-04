package com.music.bridge;

public class SingleTrackRelease extends MusicRelease {
    
    public SingleTrackRelease(StreamingPlatformGateway gateway, String title, String upcOrIsrc) {
        super(gateway, title, upcOrIsrc);
    }

    @Override
    public void publishRelease() {
        System.out.println("[Single Track Release] Initiating distribution for single: '" + title + "'");
        gateway.authenticate();
        gateway.uploadAudioMetadata(title, upcOrIsrc, 1);
    }
    
}
