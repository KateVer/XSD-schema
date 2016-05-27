package com.company.business.model.services;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;

import com.company.business.model.resources.Food;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
/**
 * Created by kateverbitskaya on 26.05.16.
 */
public class SaxDemo {

    public static void main(String[] args) throws ParserConfigurationException,
             SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("src/com/company/business/model/resources/menu.xml"));

        // включение проверки действительности
        reader.setFeature("http://xml.org/sax/features/validation", true);
        // включение обработки пространств имен
        reader.setFeature("http://xml.org/sax/features/namespaces", true);
        //включение канонизации строк
        reader.setFeature("http://xml.org/sax/features/string-interning", true);
        //отключение обработки схем
        reader.setFeature("http://apache.org/xml/features/validation/schema", false);

        List<Food> menu = handler.getFoodList();

        for (Food food : menu) {
            System.out.println(food.getName());
        }

    }

}
