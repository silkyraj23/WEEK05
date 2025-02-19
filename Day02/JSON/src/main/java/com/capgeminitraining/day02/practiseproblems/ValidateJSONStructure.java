package com.capgeminitraining.day02.practiseproblems;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ValidateJSONStructure {
    public static void main(String[] args) {
        String filePath = "src/main/resources/Student.JSON";
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Validate structure
            if (rootNode.has("Name") && rootNode.has("Age") && rootNode.has("Email")) {
                System.out.println("JSON structure is valid!");
            } else {
                System.out.println("JSON structure is invalid! Required fields are missing.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
