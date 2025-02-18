package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;

public class WriteDataToCSVFiles {
    public static void main(String[] args) {
        String filePath="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\EmployeeDetails.csv";
        try(CSVWriter writer=new CSVWriter(new FileWriter(filePath))){
            String set[]={"ID","Name","Dept","Salary"};
            String set1[]={"1","Silky","SE","1000000"};
            String set2[]={"2","Aditya","IT","100000"};
            String set3[]={"3","Ankit","SE","600000"};
            String set4[]={"4","Anshu","IT","100000"};
            String set5[]={"5","Tiwari","SE","900000"};
            String set6[]={"5","Khushi","IT","200000"};
            String set7[]={"5","Nishu","SE","600000"};
            String set8[]={"5","Nimish","IT","300000"};
            String set9[]={"5","Arjun","SE","400000"};
            String set10[]={"5","Rajput","IT","600000"};
            writer.writeNext(set);
            writer.writeNext(set1);
            writer.writeNext(set2);
            writer.writeNext(set3);
            writer.writeNext(set4);
            writer.writeNext(set5);
            writer.writeNext(set6);
            writer.writeNext(set7);
            writer.writeNext(set8);
            writer.writeNext(set9);
            writer.writeNext(set10);
            writer.flush();
            System.out.println("Data Entered Successfully 🎉");

        }
        catch(Exception e){
            System.out.println("Error reading the file" + e.getMessage());
        }
    }
}
