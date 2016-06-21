package com.company.business.dao;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class DAOException extends Exception {
    private final static long serialVersionUID = 1L;

    public DAOException(String message, Exception e){
        super(message, e);
    }
}
