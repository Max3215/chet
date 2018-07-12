package com.qmcs.common.util;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

/**
 * @ClassName(类名) : PraseXmlUtil
 * @Description(描述) : xml解析工具
 * @author(作者) ：suyl
 */

public class PraseXmlUtils {

    private static Logger log = Logger.getLogger(PraseXmlUtils.class);

    /**
     * @Description(功能描述) : 解析xml（文件格式）
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年7月23日 上午9:25:57
     * @exception :
     * @param file 
     * @return Map<String,Object>
     */
    public static Map<String, Object> parseXmlFile(File file) {
        SAXReader saxReader = new SAXReader();
        Map<String, Object> result = null;
        Document document;
        try {
            try {
                document = saxReader.read(file);
                Element root = document.getRootElement();
                result = PraseXmlUtils.listNodes(root);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (DocumentException e) {
            log.error("解析失败", e);
        }
        return result;
    }

    /**
     * @Description(功能描述) : 解析xml（xml格式字符串）
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年7月23日 上午10:22:36
     * @param text : xml格式字符串
     * @return Map<String,Object>
     */
    public static Map<String, Object> parseXmlString(String text) {
        Map<String, Object> result = null;
        try {
            Document document = DocumentHelper.parseText(text);
            Element root = document.getRootElement();
            result = PraseXmlUtils.listNodes(root);
        } catch (DocumentException e) {
            log.error("解析失败", e);
        }
        return result;
    }

    /**
     * @Description(功能描述) : 解析xml（xml格式字符串）获取指定节点
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年7月23日 上午10:24:15
     * @param text : xml格式字符串
     * @param node : 节点名称
     * @return Map<String,Object>
     */
    public static Map<String, Object> parseXmlStringByNode(String text, String node) {
        Map<String, Object> result = null;
        try {
            Document document = DocumentHelper.parseText(text);
            Element e = (Element) document.selectSingleNode("//" + node);
            result = PraseXmlUtils.listNodes(e);
        } catch (DocumentException e) {
            log.error("解析失败", e);
        }
        return result;
    }

    /**
     * @Description(功能描述) : 解析xml（xml格式字符串）获取指定节点
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年7月23日 上午10:22:36
     * @param text : xml格式字符串
     * @param node : 节点名称
     * @return List<Map<String,Object>>
     */
//    @SuppressWarnings("unchecked")
//    public static List<Map<String, Object>> parseXmlStringByListNode(String text, String node) {
//        List<Map<String, Object>> list = null;
//        try {
//            Document document = DocumentHelper.parseText(text);
//            List<Element> es = document.selectNodes("//" + node);
//            if (es.size() > 0) {
//                list = new ArrayList<Map<String, Object>>();
//                for (Element e : es) {
//                    Map<String, Object> map = PraseXmlUtils.listNodes(e);
//                    list.add(map);
//                }
//            }
//        } catch (DocumentException e) {
//            log.error("解析失败", e);
//        }
//        return list;
//    }

    /**
     * @Description(功能描述) : 遍历当前节点元素下面的所有(元素的)子节点
     * @author(作者) ： suyl
     * @date (开发日期) : 2015年7月23日 上午10:19:33
     * @param node 
     * @return Map<String,Object>
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> listNodes(Element node) {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<Element> iterator = node.elementIterator();
        while (iterator.hasNext()) {
            Element e = iterator.next();
            if (e.elements().size() > 0) {
                if (node.elements(e.getName()).size() > 1) {
                    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                    List<Element> listNodes = node.elements(e.getName());
                    for (Element element : listNodes) {
                        list.add(listNodes(element));
                    }
                    map.put(e.getName(), list);
                } else {
                    map.put(e.getName(), listNodes(e));
                }
            } else {
                map.put(e.getName(), e.getTextTrim());
            }
        }
        return map;
    }

}
