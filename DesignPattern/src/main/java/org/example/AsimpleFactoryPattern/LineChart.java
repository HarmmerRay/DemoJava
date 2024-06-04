package org.example.AsimpleFactoryPattern;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: LineChart
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:07 AM
 * @version: 1.0
 */

public class LineChart implements Chart{
    public LineChart() {
        System.out.println("创建折线图!");
    }

    @Override
    public void display() {
        System.out.println("显示折线图!");
    }
}