package com.capgeminitraining.day02.handsonpracticeproblems;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
class Student{
    String name;
    int age;
    Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public JSONObject toJSON(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name",this.name);
        jsonObject.put("age",this.age);
        return jsonObject;
    }
}
public class ListToJSONArray {
    public static void main(String[] args) {
        ArrayList<Student>list=new ArrayList<>();
        list.add(new Student("Shamiksha",19));
        list.add(new Student("Ankit",23));
        list.add(new Student("Om tiwari",22));
        list.add(new Student("Anshu priya",21));
        list.add(new Student("Rishita",20));
        JSONArray jsonArray=new JSONArray();
        for(Student s : list){
            jsonArray.put(s.toJSON());
        }
        System.out.println(jsonArray.toString());
    }
}
