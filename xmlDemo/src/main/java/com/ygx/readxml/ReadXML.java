package com.ygx.readxml;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: YaoGuangXun
 * @date: 2018/11/2 17:01
 * @Version: 1.0
 */
public class ReadXML {

    public static String getHostURI(){
        // 获取项目路径    D:\git\daotie\daotie
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(courseFile);
        return courseFile;

    }

    /**
     * @Description: 通过DOM 读取XML
     * @Author: YaoGuangXun
     * @Date: 2018/11/2 17:45
     * @Param: No such property: code for class: Script1
     * @Return
     **/
    @Test
    public void readXMLByDOM() {
        //调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂。
        DocumentBuilderFactory doc = DocumentBuilderFactory.newInstance();
        try {
            // 调用工厂对象的 newDocumentBuilder方法得到 DOM 解析器对象。 D:\WorkSpace\IDEA\SpringMVC_test\xmlDemo\src\main\java\xml\demo.xml
            DocumentBuilder db = doc.newDocumentBuilder();
//           调用 DOM 解析器对象的 parse() 方法解析 XML 文档
            Document document = db.parse(new File("D:/WorkSpace/IDEA/SpringMVC_test/xmlDemo/src/main/java/xml/demo.xml"));
// 获取节点集合
            NodeList nodeList = document.getElementsByTagName("stu");

            System.out.println(nodeList);

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(document.getElementsByTagName("name"));
                System.out.println(document.getElementsByTagName("name").item(i));
                System.out.println(document.getElementsByTagName("name").item(i).getFirstChild());
                System.out.println(document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
                System.out.println("姓名：" + document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue());
                System.out.println("年龄：" + document.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());
                System.out.println("性别：" + document.getElementsByTagName("sex").item(i).getFirstChild().getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readXMLByDOM01() {
        //  调用 DocumentBuilderFactory.newInstance() 方法得到创建 DOM 解析器的工厂。
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            //  调用工厂对象的 newDocumentBuilder方法得到 DOM 解析器对象.
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            // (4) 把要解析的 XML 文档转化为输入流，以便 DOM 解析器解析它
            InputStream inputStream = new FileInputStream("D:/WorkSpace/IDEA/SpringMVC_test/xmlDemo/src/main/java/xml/demo.xml");

            //  (5) 调用 DOM 解析器对象的 parse() 方法解析 XML 文档，得到代表整个文档的 Document 对象，进行可以利用DOM特性对整个XML文档进行操作了。
            Document document = documentBuilder.parse(inputStream);

//            (6) 得到 XML 文档的根节点

            Element root = document.getDocumentElement();
            System.out.println("根节点：" + root.getNodeName());

//            (7) 得到节点的子节点
            NodeList childList = root.getChildNodes();
            System.out.println("----:" + root.getElementsByTagName(root.getNodeName()));
            System.out.println("子节点集合：" + childList);

            if (childList != null) {

                for (int i = 0; i < childList.getLength(); i++) {
                    Node node = childList.item(i);
                    System.out.println("节点：" + node.getNodeValue());
                    // TEXT_NODE 说明该节点是文本节点
                    // ELEMENT_NODE 说明该节点是个元素节点

                }
            }
            NodeList node = root.getElementsByTagName("stus");
            if (node != null) {
                for (int i = 0; i < node.getLength(); i++) {
                    Node str = node.item(i);
                    String s = str.getFirstChild().getNodeValue();
                    System.out.println(s);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: 通过dom4j 读取xml
     * @Author: YaoGuangXun
     * @Date: 2018/11/5 10:36
     * @Param: No such property: code for class: Script1
     * @Return
     **/
    @Test
    public void readXMLByDOM4J() {

        File file = new File("D:/WorkSpace/IDEA/SpringMVC_test/xmlDemo/src/main/java/xml/demo.xml");

        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document document = reader.read(file);
            org.dom4j.Element root = document.getRootElement();
            System.out.println("root::" + root);

            for (Iterator i = root.elementIterator("stu"); i.hasNext(); ) {
                org.dom4j.Element node = (org.dom4j.Element) i.next();
                System.out.println("test:" + node.getPath());
                System.out.println("姓名：" + node.elementText("name"));
                System.out.println("年龄：" + node.elementText("age"));
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    /**
     *  通过JDOM的方式读取XML 文件中的内容
     * @Description:
     * @Author: YaoGuangXun
     * @Date: 2018/11/5 11:02
     * @Param: No such property: code for class: Script1
     * @Return
     **/
    @Test
    public void readXMLByJDOM() {

        long fistMillis = System.currentTimeMillis();

        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File(ReadXML.getHostURI()+"/src/main/java/xml/demo.xml");

        try {
            org.jdom.Document document = saxBuilder.build(file);
            org.jdom.Element element = document.getRootElement();

            List list = element.getChildren();
            System.out.println("节点集合："+list);

            for (int i=0; i< list.size() ; i++){
               org.jdom.Element element1 =(org.jdom.Element)list.get(i);

                System.out.println("名字："+ element1.getChild("name").getText());
                System.out.println("年龄："+ element1.getChild("age").getText());
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readXMLbySAX(){

    }


}
