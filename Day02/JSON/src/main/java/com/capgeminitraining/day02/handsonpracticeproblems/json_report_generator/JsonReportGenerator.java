package com.capgemini.hands_on_practice_problem.json_report_generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JsonReportGenerator {

    public static boolean writeReport() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DATABASE_URL");
        String user = "root";
        String password = dotenv.get("PASSWORD");


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            while (rs.next()) {
                ObjectNode employee = objectMapper.createObjectNode();
                employee.put("id", rs.getInt("id"));
                employee.put("name", rs.getString("name"));
                employee.put("email", rs.getString("email"));
                employee.put("department", rs.getString("department"));
                employee.put("salary", rs.getDouble("salary"));

                jsonArray.add(employee);
            }

            // Write JSON to a file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/capgemini/hands_on_practice_problem/json_report_generator/report.json"), jsonArray);
            System.out.println("✅ JSON Report Generated: report.json");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
