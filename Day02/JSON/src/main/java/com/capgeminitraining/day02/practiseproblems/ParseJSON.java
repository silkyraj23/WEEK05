package com.capgeminitraining.day02.practiseproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ParseJSON {
    public static void main(String[] args) {
        String filePath = "src/main/resources/StudentArray.JSON";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {

                    if (node.has("Age") && node.get("Age").asInt() > 25) {
                        // Print details
                        System.out.print("Name : " + node.get("Name").asText()+"\t\t");
                        System.out.print("Age  : " + node.get("Age").asInt()+"\t\t");
                        System.out.print("ID   : " + node.get("ID").asInt()+"\t\t");
                        System.out.print("Email  : " + node.get("Email").asText()+"\t\t");
                        System.out.print("Blood Group : " + node.get("Blood_Group").asText());
                        System.out.println();

                    }
                }
            } else {
                System.out.println("Error: JSON data is not an array.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
