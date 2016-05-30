package com.company.news.view;

import com.company.news.entity.News;
import com.company.news.entity.Request;
import com.company.news.entity.Response;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class View {
    public Request doUserActionSave(){

        Request request = new Request();
        request.setCommandName("SAVE_NEW_NEWS");
        request.setTitle("I want to execute command SAVE");
        News news = new News();
        news.setId(7L);
        news.setContent("News Content");
        news.setTitle("Just First Title for News");
        news.setProvider("Valera");
        news.setDate("07/08/2016");
        request.setNews(news);
        request.setSubCategoryName("tennis");
        request.setCategoryName("sports");
        return request;
    }

    public Request doUserActionFind(){

        Request request = new Request();
        request.setCommandName("FIND_NEWS");
        request.setTitle("I want to execute command SAVE");
        request.setSubCategoryName("tennis");
        request.setCategoryName("sports");
        return request;
    }

    public void printAnswer(Response response){
        System.out.println("RESPONSE:" + response);
    }

    public void printAnswer(String message){
        System.out.println("MESSAGE:" + message);

    }

}

