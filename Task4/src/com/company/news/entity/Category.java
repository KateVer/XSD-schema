package com.company.news.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */

public class Category {
    private Long id;
    private String name;
    private List<SubCategory> subCategoryList;

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }


    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    @XmlElement(name = "subcategory")
    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategoryList=" + subCategoryList +
                '}';
    }
}
