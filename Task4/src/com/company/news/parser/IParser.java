package com.company.news.parser;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public interface IParser {
    Object getObject(File file, Class c) throws JAXBException;
    void saveObject(File file, Object o) throws JAXBException;
}
