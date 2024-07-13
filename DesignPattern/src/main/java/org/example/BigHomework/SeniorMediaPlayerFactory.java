package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 7/3/2024 2:12 PM
 */

public class SeniorMediaPlayerFactory implements MediaPlayerFactory{
    @Override
    public MediaPlayer createAudioPlayer() {
        System.out.println("创建高级音频播放器");
        return new AudioPlayer();
    }

    @Override
    public MediaPlayer createVideoPlayer() {
        System.out.println("创建高级视频播放器");
        return new VideoPlayer();
    }
}
