package com.company.business.engine;

/**
 * Created by kateverbitskaya on 06.07.16.
 */
public class MultOperation implements Operation {
    @Override
    public float calculate(float [] values) {
        float result = 0;
        for (float element:values){
            result*=element;
        }
        return result;
    }
}
