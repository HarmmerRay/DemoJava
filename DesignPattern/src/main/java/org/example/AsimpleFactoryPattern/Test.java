package org.example.AsimpleFactoryPattern;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: Test
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:15 AM
 * @version: 1.0
 */

public class Test {
    public static void main(String[] args) {
        ChartFactory.getChart("piechart").display();
    }
}
