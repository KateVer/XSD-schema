package com.company.news.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
@XmlRootElement(name = "catalog")
public class Catalog {
    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }
    @XmlElement(name = "category")
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "categoryList=" + categoryList +
                '}';
    }
}
