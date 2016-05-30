package com.company.news.entity;

import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class Response {
    private String content;
    private String status;
    public Response(List<News> news){
        if (news.size()>0){
            content = news.toString();
            status = "sucesseful";
        } else{
            content = "NOTHING TO DISPLAY";
            status = "failed";
        }
    }

    @Override
    public String toString() {
        return "Response{" +
                "content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Response(){
        content = "The news is added";
        status = "succesful";
    }

}
