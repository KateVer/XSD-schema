package com.company.business.service;

import com.company.business.engine.MultOperation;
import com.company.business.engine.Operation;
import com.company.business.engine.SumOperation;
import com.company.business.engine.SumPowOperation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by kateverbitskaya on 06.07.16.
 */
public class FileService {



    public String read(String fileName) {
        try (FileInputStream inFile = new FileInputStream(fileName)) {
            byte[] str;
            str = new byte[inFile.available()];
            inFile.read(str);
            return new String(str);
        } catch (IOException ex) {
           System.out.println("Error" + ex);
            return null;
        }

    }

    public Operation getOperation(String file) {
        Operation operation = null;
        int newLine = file.indexOf("\n");
        if (newLine > 0) {
            String operationNumber = file.substring(0, newLine).trim();
            int operationCase = Integer.parseInt(operationNumber);
            switch (operationCase) {
                case 1: {
                    operation = new SumOperation();
                }
                break;

                case 2: {
                    operation = new MultOperation();
                }
                break;

                case 3: {
                    operation = new SumPowOperation();
                }
                break;
            }
            return operation;
        } else {
            System.out.println("Can't find input command");
            return null;
        }

    }

    public Float[] getArray(String str) {
        int newLine = str.indexOf("\n");
        if (newLine > 0) {
            str = str.substring(newLine).trim();
            float [] array;
            List<Float> temps = new ArrayList<Float>();
            if (!str.isEmpty()) {
                String[] tabOfFloatString = str.split(" ");
                for(String s : tabOfFloatString){

                    float res = Float.parseFloat(s);
                    temps.add(res);

                }
                return temps.toArray(new Float[0]);
            } else {
                System.out.println("Can't find input array");
                return null;
            }
        } else {
            System.out.println("Can't find input array");
            return null;
        }
    }


}
