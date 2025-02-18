package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVReader;
import java.io.FileReader;
public class ReadCSVFileAndCountRows {
    public static void main(String[] args) {
        String filePath="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\EmployeeDetails.csv";
        int noOfRows=0;
        try(CSVReader reader= new CSVReader(new FileReader(filePath))){
            String data[];
            while((data=reader.readNext()) != null){
                for(int i=0;i<data.length;i++){
                    System.out.print(data[i]+ ",");
                }
                System.out.println();
                noOfRows++;
            }
        }catch (Exception e){
            System.out.println("Error reading the file "+ e.getMessage());
        }
        System.out.println("Total No of Rows in CSV file is " + noOfRows);
    }
}
