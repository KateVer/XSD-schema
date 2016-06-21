package com.company.business.dao;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class DBConnectionPoolException extends Exception{
    private final static long serialVersionUID = 1L;

    public DBConnectionPoolException(String message, Exception e){
        super(message, e);
    }
}
