package com.epam.business.services;

import com.epam.business.model.Category;
import com.epam.business.model.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String filepath = "src/com/epam/business/model/resources/menu.xml";

        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + document.getDocumentElement().getNodeName());

            //  get nodes with name category
            //  now XML is fully loaded into memory
            //  as the object of Document
            NodeList nodeCategoryList = document.getElementsByTagName("category");

            //  create the list of Category objects from it
            List<Category> categoryList = new ArrayList<Category>();
            for (int i = 0; i < nodeCategoryList.getLength(); i++) {
                categoryList.add(getCategory(nodeCategoryList.item(i)));
            }

            //  print the information about every Category object to the console
            for (Category category : categoryList) {
                System.out.println(category.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    // create Category object from document's node
    private static Category getCategory(Node node) {
        Category category = new Category();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            category.setId(Integer.parseInt(element.getAttribute("id")));
            category.setType(element.getAttribute("type"));
            //  get nodes with the name Food
            //  now XML is fully loaded into memory
            //  the object of Document
            NodeList nodeFoodList = element.getElementsByTagName("food");

            // create the list of Food objects from it
            List<Food> foodList = new ArrayList<Food>();
            for (int i = 0; i < nodeFoodList.getLength(); i++) {
                foodList.add(getFood(nodeFoodList.item(i)));
            }
            category.setFood(foodList);
        }

        return category;
    }

    // create the object Food from the docement's node
    private static Food getFood(Node node) {
        Food food = new Food();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            food.setId(Integer.parseInt(element.getAttribute("id")));
            food.setName(getTagValue("name", element));
            food.setGram(getTagValue("gram", element));
            food.setDescription(getTagValue("description", element));
            food.setPhoto(getTagValue("photo", element));
            food.setPrice(Integer.parseInt(getTagValue("price", element)));
        }

        return food;
    }

    // get the value of the element by tag
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
