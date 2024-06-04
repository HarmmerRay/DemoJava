package org.example.AsimpleFactoryPattern;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: HistogramChart
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:07 AM
 * @version: 1.0
 */

public class HistogramChart implements Chart{
    public HistogramChart() {
        System.out.println("创建柱状图!");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图!");
    }
}
