package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:35 PM
 */

public class VideoPlayer extends MediaPlayer {
    private final VideoPlayerAdapter videoAdapter; // 桥接

    public VideoPlayer(VideoPlayerAdapter videoPlayerAdapter) {
        this.videoAdapter = videoPlayerAdapter;
    }

    @Override
    public void play() {
        System.out.println("我是视频播放器");
        videoAdapter.play("defaultVideoPlayer .mp4");
    }

    @Override
    public void setPlayStrategy(PlayStrategy playStrategy) {

    }
}
