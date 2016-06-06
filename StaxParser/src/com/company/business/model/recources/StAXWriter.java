package com.company.business.model.recources;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Created by kateverbitskaya on 06.06.16.
 */
public class StAXWriter {

    public static void main(String[] args) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();

        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("com/company/business/model/recoutces/menu.xml"));
        }
    }
}
