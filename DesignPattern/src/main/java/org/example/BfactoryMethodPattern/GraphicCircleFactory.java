package org.example.BfactoryMethodPattern;

public class GraphicCircleFactory implements GraphicAbstractFactory{
    @Override
    public GraphicProduct create() {
        System.out.println("创建圆");
        return new GraphicCircle();
    }
}
