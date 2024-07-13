package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:35 PM
 */

public class AudioPlayer extends MediaPlayer{
    @Override
    public void play() {
        System.out.println("我是音频播放器");
    }

    @Override
    public void setPlayStrategy(PlayStrategy playStrategy) {

    }
}
