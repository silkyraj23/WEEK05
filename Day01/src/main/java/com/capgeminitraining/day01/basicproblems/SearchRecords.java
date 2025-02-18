package com.capgeminitraining.day01.basicproblems;
import com.opencsv.CSVReader;
import java.io.FileReader;
public class SearchRecords {
    public static void main(String[] args) {
        String filePath="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\EmployeeDetails.csv";
        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            String data[];
            while((data =reader.readNext()) !=null){
                if(data[1].equalsIgnoreCase("silky")){
                    System.out.println("department of the "+ data[1] +" is "+ data[2]);
                    System.out.println("Salary of the "+ data[1] +" is "+ data[3]);
                }
            }
        }catch (Exception e){
            System.out.println("Error File Not found");
        }
    }
}
