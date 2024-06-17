package org.example.AsimpleFactoryPattern;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @projectName: DemoJava
 * @package: org.example.AsimpleFactoryPattern
 * @className: XmlUtil
 * @author: HammerRay
 * @description: TODO
 * @date: 6/4/2024 11:20 AM
 * @version: 1.0
 */

public class XmlUtil {
    public static String getCharType() {
        try{
            // 创建文档对象 DocumentBuilderFactory DocumentBuilder Document
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("DesignPattern\\src\\main\\java\\org\\example\\AsimpleFactoryPattern\\config.xml"));
            // 获取包含图表类型的文本节点
            NodeList nl = doc.getElementsByTagName("chartType");
            Node classNode = nl.item(0).getFirstChild();
            String chartType = classNode.getNodeValue().trim();
            return chartType;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}