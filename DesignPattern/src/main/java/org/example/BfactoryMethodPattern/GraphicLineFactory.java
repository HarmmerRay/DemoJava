package org.example.BfactoryMethodPattern;

public class GraphicLineFactory implements GraphicAbstractFactory{
    @Override
    public GraphicProduct create() {
        System.out.println("创建线");
        return new GraphicLine();
    }
}
