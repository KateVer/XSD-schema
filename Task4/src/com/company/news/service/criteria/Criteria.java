package com.company.news.service.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class Criteria {

    private Map<String, Object> filters = new HashMap<String, Object>();

    public void put(String key, Object value){
        filters.put(key, value);
    }

    public Map<String, Object> getFilter(){
        return filters;
    }

}
