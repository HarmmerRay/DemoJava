package org.example.BigHomework;

/**
 * @author: HammerRay
 * @description:
 * @date: 6/30/2024 4:40 PM
 */

public class NormalPlayStrategy implements PlayStrategy{
    @Override
    public void execute(MediaPlayer player) {
        System.out.println("我是1.0倍播放");
    }
    // ... 其他播放策略，如快速播放、循环播放等
}
