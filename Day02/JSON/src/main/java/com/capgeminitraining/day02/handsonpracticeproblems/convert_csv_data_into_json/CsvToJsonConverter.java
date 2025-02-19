package com.capgemini.hands_on_practice_problem.convert_csv_data_into_json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter {

    //method to convert csv file to json
// Method to convert CSV file to JSON
    public static String convertCsvToJson(String csvFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (String header : csvParser.getHeaderNames()) {
                    jsonObject.put(header, record.get(header));
                }
                jsonArray.add(jsonObject);
            }

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);

        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + e.getMessage());
        }
    }
}
