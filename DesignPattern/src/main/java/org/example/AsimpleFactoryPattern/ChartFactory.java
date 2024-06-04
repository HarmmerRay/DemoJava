package org.example.AsimpleFactoryPattern;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: ChartFactory
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:06 AM
 * @version: 1.0
 */

public class ChartFactory {
    public static Chart getChart(String type) {
        Chart chart = null;
        if(type.equalsIgnoreCase("LineChart")) {
            chart = new LineChart();
            System.out.println("初始化设置折线图图!");
        }
        else if(type.equalsIgnoreCase("HistogramChart")) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图!");
        }
        else if(type.equalsIgnoreCase("PieChart")) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图!");
        }
        return chart;
    }
}
