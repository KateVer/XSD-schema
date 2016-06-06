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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (id != food.id) return false;
        if (price != food.price) return false;
        if (photo != null ? !photo.equals(food.photo) : food.photo != null) return false;
        if (name != null ? !name.equals(food.name) : food.name != null) return false;
        if (description != null ? !description.equals(food.description) : food.description != null) return false;
        return gram != null ? gram.equals(food.gram) : food.gram == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (gram != null ? gram.hashCode() : 0);
        return result;
    }
}
