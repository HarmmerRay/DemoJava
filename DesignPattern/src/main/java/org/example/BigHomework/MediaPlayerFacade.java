package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:34 PM
 */

public class MediaPlayerFacade {
    private final MediaPlayer mediaPlayer;

    public MediaPlayerFacade(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void play() {
        mediaPlayer.play();
    }

    // ... 其他统一接口方法
}
