package com.capgemini.ipl_and_censor_analyzer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) throws IOException {
        String jsonInputPath = "src/main/java/com/capgemini/ipl_and_censor_analyzer/ipl_data.json";
        String csvInputPath = "src/main/java/com/capgemini/ipl_and_censor_analyzer/ipl_data.csv";
        String jsonOutputPath = "src/main/java/com/capgemini/ipl_and_censor_analyzer/ipl_data_censored.json";
        String csvOutputPath = "src/main/java/com/capgemini/ipl_and_censor_analyzer/ipl_data_censored.csv";

        processJsonFile(jsonInputPath, jsonOutputPath);
        processCsvFile(csvInputPath, csvOutputPath);
    }

    private static void processJsonFile(String inputPath, String outputPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(inputPath));

        for (JsonNode match : rootNode) {
            ((ObjectNode) match).put("team1", maskTeamName(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", maskTeamName(match.get("team2").asText()));
            ((ObjectNode) match).put("winner", maskTeamName(match.get("winner").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), rootNode);
        System.out.println("Censored JSON file generated: " + outputPath);
    }

    private static void processCsvFile(String inputPath, String outputPath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(inputPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

        writer.write(lines.get(0));  // Write header
        writer.newLine();

        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",");
            columns[1] = maskTeamName(columns[1]); // Mask team1
            columns[2] = maskTeamName(columns[2]); // Mask team2
            columns[5] = maskTeamName(columns[5]); // Mask winner
            columns[6] = "REDACTED"; // Redact player_of_match

            writer.write(String.join(",", columns));
            writer.newLine();
        }

        writer.close();
        System.out.println("Censored CSV file generated: " + outputPath);
    }

    static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}
