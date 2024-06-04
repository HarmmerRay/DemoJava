package org.example.AsimpleFactoryPattern;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: PieChart
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:07 AM
 * @version: 1.0
 */

public class PieChart implements Chart{
    public PieChart(){
        System.out.println("创建饼状图!");
    }
    @Override
    public void display() {
        System.out.println("显示饼状图!");
    }
}