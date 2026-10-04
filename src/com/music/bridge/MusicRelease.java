package com.music.bridge;

public abstract class MusicRelease {

    protected StreamingPlatformGateway gateway;
    protected String title;
    protected String artist;
    protected String upcOrIsrc;

    public MusicRelease(StreamingPlatformGateway gateway, String title, String upcOrIsrc) {
        this.gateway = gateway;
        this.title = title;
        this.upcOrIsrc = upcOrIsrc;
    }

    public void setGateway(StreamingPlatformGateway gateway) { 
        this.gateway = gateway; 
    }

    public String getTitle() { 
        return title; 
    }

    public String getUpcOrIsrc() { 
        return upcOrIsrc; 
    }
    
    public abstract void publishRelease();
}
