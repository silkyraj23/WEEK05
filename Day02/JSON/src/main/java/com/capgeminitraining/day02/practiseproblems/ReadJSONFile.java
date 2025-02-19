package com.capgeminitraining.day02.practiseproblems;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class ReadJSONFile {
    public static void main(String[] args) {
        String file="C:\\Users\\Shamiksha\\Desktop\\CG-Bridgelabz Training\\WEEK05\\Day02\\JSON\\src\\main\\resources\\Student.JSON";
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonNode node=objectMapper.readTree(new File(file));
            String name=node.get("Name").asText();
            String email=node.get("Email").asText();
            //printing the output
            System.out.println("Name : "+ name );
            System.out.println("Email : "+ email);

        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
}
