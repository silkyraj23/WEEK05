package com.capgeminitraining.day01.basicproblems;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSVRecords {
    public static void main(String[] args) {
        String filePath = "C:/Users/Shamiksha/Desktop/CG-Bridgelabz Training/WEEK05/Day01/src/main/resources/EmployeeDetails.csv";
        List<String[]> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] data;
            boolean isHeader = true;
            while ((data = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                records.add(data);
            }
        } catch (Exception e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort records by Salary (column index 3) in descending order
        records.sort((a, b) -> {
            try {
                return Integer.compare(Integer.parseInt(b[3].trim()), Integer.parseInt(a[3].trim()));
            } catch (NumberFormatException e) {
                return 0; // Ignore invalid values
            }
        });
        // Print top 5 highest-paid employees
        System.out.println("Top 5 Highest-Paid Employees:");
        System.out.println("---------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "Name", "Dept", "Salary");
        int limit = Math.min(5, records.size());
        for (int i = 0; i < limit; i++) {
            String[] emp = records.get(i);
            System.out.printf("%-10s %-15s %-10s %-10s%n", emp[0], emp[1], emp[2], emp[3]);
        }
    }
}
