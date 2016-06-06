package com.epam.business.model;

import java.util.List;

/**
 * Created by kateverbitskaya on 22.05.16.
 */
public class Category {
    private int id;
    private String type;
    private List<Food> food;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", food=" + food +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (type != null ? !type.equals(category.type) : category.type != null) return false;
        return food != null ? food.equals(category.food) : category.food == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (food != null ? food.hashCode() : 0);
        return result;
    }
}
