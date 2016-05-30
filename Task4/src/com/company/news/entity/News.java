package com.company.news.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class News {
    private String provider;
    private String date;
    private String content;
    private Long id;
    private String title;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDate() {
        return date;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    @XmlElement
    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    @XmlAttribute
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlAttribute
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "provider='" + provider + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
