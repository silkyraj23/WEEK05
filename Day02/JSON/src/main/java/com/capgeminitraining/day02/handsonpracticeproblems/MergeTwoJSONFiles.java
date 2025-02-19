package com.capgeminitraining.day02.handsonpracticeproblems;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeTwoJSONFiles {
    public static void main(String[] args) {
        String file1 = "src/main/resources/Candidate.JSON";
        String file2 = "src/main/resources/Student.JSON";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node1 = objectMapper.readTree(new File(file1));
            JsonNode node2 = objectMapper.readTree(new File(file2));
            JSONObject jsonObject1 = new JSONObject(objectMapper.writeValueAsString(node1));
            JSONObject jsonObject2 = new JSONObject(objectMapper.writeValueAsString(node2));

            for (String key : jsonObject2.keySet()) {
                jsonObject1.put(key, jsonObject2.get(key));
            }
            System.out.println(jsonObject1);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
