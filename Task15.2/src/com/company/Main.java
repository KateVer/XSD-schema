package com.company;

import com.company.business.service.FileService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

//        String st, full;
//        full="";
//        BufferedReader br = new BufferedReader(new FileReader("recource/in1.dat"));
//        while ((st=br.readLine())!=null) {
//            full+=st;
//        }
//        System.out.println(full);

        FileService fileService = new FileService();
        String fileContent = fileService.read("recource/in1.dat");
        System.out.println(fileContent);
        fileService.getOperation(fileContent);
        Float[] array = fileService.getArray(fileContent);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }




    }
}
