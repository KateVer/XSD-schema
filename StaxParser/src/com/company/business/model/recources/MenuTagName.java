package com.company.business.model.recources;

/**
 * Created by kateverbitskaya on 06.06.16.
 */
public enum MenuTagName {

    PHOTO, NAME, DESCRIPTION, PRICE, GRAM, FOOD, CATEGORY, MENU;

    public static MenuTagName getElementTagName(String element){
        switch (element) {
            case "photo":
                return PHOTO;
            case "price":
                return PRICE;
            case "description":
                return DESCRIPTION;
            case "gram":
                return GRAM;
            case "food":
                return FOOD;
            case "name":
                return NAME;
            case "category":
                return CATEGORY;
            case "menu":
                return MENU;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class, element);
        }
    }
}
