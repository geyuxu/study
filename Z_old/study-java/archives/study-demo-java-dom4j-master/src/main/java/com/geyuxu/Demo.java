/*
 * @(#) Demo.java V3.0 2016年09月27日
 * 百联集团	版权所有
 * 
 * 
 *
 * @Title: Demo.java
 * @Package com.geyuxu 
 * @author 葛于旭
 * @date 2016年09月27日 13:53:03
 * @version V3.0
 * 历史版本：
 * 	1. 【2016年09月27日】 创建文件   by 葛于旭
 */
package com.geyuxu;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author 葛于旭
 * @version V3.0
 * @ClassName: Demo
 * @date 2016年09月27日 13:53:03
 */
public class Demo {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        String text = "<?xml version='1.0' encoding='utf-8'?><response><result>0</result><desc>成功</desc><sms><phone>138138138138</phone><content>感谢您成为xxx会员，购物满400减200可累计！大牌云集全球甄选,回T退订</content><subcode>11111</subcode><delivertime>2016-09-22 15:59:20</delivertime></sms><sms><phone>138138138139</phone><content>购物满400减200可累计！大牌云集全球甄选，回T退订</content><subcode>22222</subcode><delivertime>2016-09-22 16:01:33</delivertime></sms><sms><phone>12222222</phone><content>33333</content><subcode>24331</subcode><delivertime>2016-09-22 16:10:58</delivertime></sms>" +
                "<sms></sms>" +
                "</response>";
        try {
            Document document = DocumentHelper.parseText(text);
            Element root = document.getRootElement();
            System.out.println(root.getName());
            Element result = root.element("result");
            System.out.println("result:"+result.getText());
            Element desc = root.element("desc");
            System.out.println("desc:"+desc.getText());

            List sms = root.elements("sms");
            for(Object o : sms){
                Element e = (Element)o;
                Element phone = e.element("phone");
                Element content = e.element("content");
                Element subcode = e.element("subcode");
                Element delivertime = e.element("delivertime");
                System.out.println("phone:"+(phone == null ? "" :phone.getText()));
                System.out.println("content:"+ (content== null ? "" :content.getText()));
                System.out.println("subcode:"+ (subcode== null ? "" :subcode.getText()));
                System.out.println("delivertime:"+ (delivertime== null ? "" :delivertime.getText()));
                System.out.println("--------------------");
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
