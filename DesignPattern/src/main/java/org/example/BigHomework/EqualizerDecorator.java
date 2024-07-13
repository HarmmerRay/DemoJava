package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:45 PM
 */

public class EqualizerDecorator extends MediaPlayerDecorator{
    private final MediaPlayer mediaPlayer;

    public EqualizerDecorator(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public MediaPlayer getDecoratedPlayer() {
        return null;
    }

    @Override
    public void play() {
        applyEqulizer();
        mediaPlayer.play();
    }

    @Override
    public void setPlayStrategy(PlayStrategy playStrategy) {

    }
}
