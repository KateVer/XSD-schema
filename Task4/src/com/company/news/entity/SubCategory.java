package com.company.news.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class SubCategory {
    private Long id;
    private String name;
    private List<News> newsList;

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

    public List<News> getNews() {
        return newsList;
    }

    @XmlElement(name = "news")
    public void setNews(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", news=" + newsList +
                '}';
    }
}
