package com.capgeminitraining.day02.handsonpracticeproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;

class ConvertJsonToXml {
    public static void main(String[] args) {
        try {
            // Read JSON File
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src/main/resources/Student.JSON"));

            // Convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            // Print XML Output
            System.out.println("Converted XML:\n" + xml);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
