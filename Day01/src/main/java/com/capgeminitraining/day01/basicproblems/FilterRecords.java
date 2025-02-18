package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String args[]) {
        String filepath = "C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day01\\src\\main\\resources\\studentsDetails.csv";
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] data;
            boolean isHeader = true;
            while ((data = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip the header row
                    continue;
                }

                try {
                    int marks = Integer.parseInt(data[3]);
                    if (marks > 80) {
                        for(int i=0;i<data.length;i++){
                            System.out.print(data[i]+",");
                        }
                        System.out.println();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid data (not a number in column 3): " + String.join(",", data));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
