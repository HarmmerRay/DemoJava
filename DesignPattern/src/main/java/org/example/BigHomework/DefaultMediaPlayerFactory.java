package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:42 PM
 */

public class DefaultMediaPlayerFactory implements MediaPlayerFactory {
    @Override
    public MediaPlayer createAudioPlayer() {
        System.out.println("创建默认音频播放器");
        return new AudioPlayer();
    }

    @Override
    public MediaPlayer createVideoPlayer() {
        System.out.println("创建默认视频播放器");
        return new VideoPlayer();
    }
}
