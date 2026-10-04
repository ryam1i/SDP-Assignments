package com.music.bridge;

public interface StreamingPlatformGateway {
    void authenticate();
    void uploadAudioMetadata(String title, String upcOrIsrc, int trackCount);
}
