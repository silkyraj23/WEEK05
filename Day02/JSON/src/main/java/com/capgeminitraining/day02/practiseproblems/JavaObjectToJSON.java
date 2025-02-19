package com.capgeminitraining.day02.practiseproblems;
import com.fasterxml.jackson.databind.ObjectMapper;
class Car {
    int speed;
    String brandName;
    String color;
    // Parameterized constructor
    public Car(int speed, String brandName, String color) {
        this.speed = speed;
        this.brandName = brandName;
        this.color = color;
    }
    // Getters
    public String getBrandName() {
        return this.brandName;
    }
    public int getSpeed() {
        return this.speed;
    }

    public String getColor() {
        return this.color;
    }
}
public class JavaObjectToJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car(60, "Mahindra", "Black");
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
