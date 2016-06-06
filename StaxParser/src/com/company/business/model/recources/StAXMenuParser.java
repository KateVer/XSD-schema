package com.company.business.model.recources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by kateverbitskaya on 06.06.16.
 */
public class StAXMenuParser {
    public static void main(String[] args) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream input = new FileInputStream("com/company/business/model/recoutces/menu.xml");
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<Food> menu = process(reader);

            for (Food food : menu) {
                System.out.println(food.getName());
                System.out.println(food.getDescription());
            }

        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
    private static List<Food> process(XMLStreamReader reader)
        throws XMLStreamException {

        List<Food> menu = new ArrayList<Food>();
        Food food = null;
        MenuTagName elementName = null;
        while (reader.hasNext()) {
            //определение типа "прочтенного" элемента (тега)
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            food = new Food();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                            food.setId(id);
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();

                    if (text.isEmpty()) {
                        break;
                    }
                    switch (elementName) {
                        case NAME:
                            food.setName(text);
                            break;
                        case PHOTO:
                            food.setPhoto(text);
                            break;
                        case PRICE:
                            food.setPrice(text);
                            break;
                        case DESCRIPTION:
                            food.setDescription(text);
                            break;
                        case GRAM:
                            food.setGram(text);
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName) {
                        case FOOD:
                            menu.add(food);
                    }
            }
        }
        return menu;
    }
}
