package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String filePath="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\EmployeeDetails.csv";
        String newFilePath="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\UpdatedEmployeeDetails";
        List list=new ArrayList<>();
        try(CSVReader reader= new CSVReader(new FileReader(filePath))){
            String data[];
            while((data=reader.readNext())!=null){
                if(data[2].equalsIgnoreCase("IT")){
                    int currentSalary=Integer.parseInt(data[3]);
                    int updatedSalary=currentSalary+(currentSalary*10)/100;
                    data[3]=String.valueOf(updatedSalary);
                }
                list.add(data);
            }
        }catch(Exception e){
            System.out.println("Error File not found ");
        }
        try(CSVWriter writer =new CSVWriter(new FileWriter(newFilePath))){
            writer.writeAll(list);
            writer.flush();
            System.out.println("Employee's salary updated");

        } catch (Exception e) {
            System.out.println(" Error File not found");
        }
    }
}
