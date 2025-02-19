package com.capgeminitraining.day02.handsonpracticeproblems;
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
            int age=node.get("Age").asInt();
            String ID=node.get("ID").asText();
            String email=node.get("Email").asText();
            String bloodGroup=node.get("Blood_Group").asText();

            //printing the output
            System.out.println("Name : "+ name );
            System.out.println("Age : "+ age );
            System.out.println("ID : "+ ID );
            System.out.println("Email: "+ email );
            System.out.println("Blood_Group : "+ bloodGroup);

        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
}

