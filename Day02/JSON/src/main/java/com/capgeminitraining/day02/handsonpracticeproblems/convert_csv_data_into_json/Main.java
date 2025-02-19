package com.capgemini.hands_on_practice_problem.convert_csv_data_into_json;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "src/main/java/com/capgemini/hands_on_practice_problem/convert_csv_data_into_json/sample.csv"; // Path to CSV file

        String jsonOutput = CsvToJsonConverter.convertCsvToJson(csvFilePath);
        System.out.println("Converted JSON:");
        System.out.println(jsonOutput);
    }
}
