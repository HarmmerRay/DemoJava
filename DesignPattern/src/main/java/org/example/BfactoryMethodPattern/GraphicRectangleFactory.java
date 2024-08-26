package org.example.BfactoryMethodPattern;

public class GraphicRectangleFactory implements GraphicAbstractFactory{
    @Override
    public GraphicProduct create() {
        System.out.println("创建长方形");
        return new GraphicRectangle();
    }
}
