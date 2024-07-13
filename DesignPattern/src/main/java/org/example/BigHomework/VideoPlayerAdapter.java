package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:36 PM
 */

public class VideoPlayerAdapter extends VideoPlayer {
    public VideoPlayerAdapter(){
        super();

    }

    public VideoPlayerAdapter(VideoPlayerAdapter videoPlayerAdapter) {
        super(videoPlayerAdapter);
    }

    public void play(String videoFileName) {
        if (videoFileName == "mp4"){
            new VideoPlayerMp4().play();
        }
        if (videoFileName == "webm"){
            new VideoPlayerWebm().play();
        }
    }
}
