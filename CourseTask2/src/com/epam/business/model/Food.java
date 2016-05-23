package com.epam.business.model;

/**
 * Created by kateverbitskaya on 22.05.16.
 */
public class Food {
    private int id;
    private String photo;
    private String name;
    private String description;
    private int price;
    private String gram;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }



    @Override
    public String toString() {
        return "Food{" +
                "photo='" + photo + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", gram='" + gram + '\'' +
                '}';
    }
}
