package com.capgeminitraining.day02.handsonpracticeproblems;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.io.File;
import java.util.Set;

public class ValidateEmailJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(new File("src/main/resources/Student.JSON"));
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
            JsonSchema schema = factory.getSchema(new File("src/main/resources/emailschema.JSON").toURI());
            Set<ValidationMessage> errors = schema.validate(jsonData);

            // Output
            if (errors.isEmpty()) {
                System.out.println("Email is valid!");
            } else {
                System.out.println("Email validation failed!");

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

