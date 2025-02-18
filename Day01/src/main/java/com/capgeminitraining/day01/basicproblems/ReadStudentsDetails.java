package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVReader;
import java.io.FileReader;
public class ReadStudentsDetails {
    public static void main(String[] args) {
        String file = "C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\studentsDetails.csv";
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            String[] data;
            boolean header = true;
            while ((data = reader.readNext()) != null) {
            if(header){
                header = false;
                System.out.println(data[0]+"\t\t"+data[1]+"\t\t"+data[2]+"\t\t"+data[3]);
                System.out.println("----------------------------------");
                continue;
            }
            for(int i=0;i<data.length;i++) {
                System.out.print(data[i] + "\t\t");
            }
            System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
