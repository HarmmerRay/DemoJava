package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 7/3/2024 7:36 PM
 */

public class DoublePlayStrategy implements PlayStrategy{
    @Override
    public void execute(MediaPlayer player) {
        System.out.println("我是二倍速播放");
    }
}
