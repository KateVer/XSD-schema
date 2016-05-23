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
}
