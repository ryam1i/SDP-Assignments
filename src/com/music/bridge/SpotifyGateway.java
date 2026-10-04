package com.music.bridge;

public class SpotifyGateway implements StreamingPlatformGateway {
    @Override 
    public void authenticate() {
        System.out.println("[Spotify Gateway] Authenticating via Spotify Partner API v2...");
    }

    @Override
    public void uploadAudioMetadata(String title, String upcOrIsrc, int trackCount) {
        System.out.println("[Spotify Gateway] Uploading audio and metadata to Spotify Partner API v2...");
        System.out.println("[Spotify Gateway] Title: " + title);
        System.out.println("[Spotify Gateway] UPC/ISRC: " + upcOrIsrc);
        System.out.println("[Spotify Gateway] Track Count: " + trackCount);
    }
}
