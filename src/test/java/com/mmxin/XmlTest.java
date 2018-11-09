package com.mmxin;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : mmxin
 * @className : XmlTest
 * @date : 2018/11/6 9:06
 */
public class XmlTest {

    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        File file = new File ("D:\\ent_project\\WaitingForever\\src\\main\\resources\\station.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> list =  root.elements();
        Set<String> valueSet = new HashSet<>();
        int index = 0 ;
        for(Element element : list){
            index ++ ;
            List<Attribute> attributeList = element.attributes();
            int i = 0;
            StringBuffer item = new StringBuffer();
            StringBuffer item2 = new StringBuffer();
            boolean isDoubles = false;
            item.append("(");
            item2.append("(");
            for (Attribute attribute : attributeList){
                i += 1 ;
                if (i == 2){
                    if (attribute.getValue().split("\\|").length > 1){
                        isDoubles = true ;
                        item.append("'"+attribute.getValue().split("\\|")[0] + "',");
                        item2.append("'"+attribute.getValue().split("\\|")[6] + "',");
                    }else{
                        item.append("'"+attribute.getValue()+"',");
                    }
                }else if (i % 3 == 0){
                    continue;
                }else if (i % 4 == 0){
                    String value = attribute.getValue();
                    String times = value.split("::::::")[2];
                    times = times.split("\\|")[0];
                    item.append("'"+times + "'");
                    item2.append("'"+times + "'");
                }else{
                    item.append("'"+attribute.getValue() + "',");
                    item2.append("'"+attribute.getValue() + "',");
                }
            }
            item.append("),");
            item2.append("),");
            if (isDoubles){
                valueSet.add(item.toString());
                System.out.println(item);
                valueSet.add(item2.toString());
                System.out.println(item2);
            }else{
                valueSet.add(item.toString());
                System.out.println(item);
            }
        }
        /*for (String s : valueSet){
            System.out.println(s);
        }*/

        System.out.println(index);
    }

}
