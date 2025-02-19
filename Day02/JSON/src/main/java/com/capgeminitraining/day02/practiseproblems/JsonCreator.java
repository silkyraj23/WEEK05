package com.capgeminitraining.day02.practiseproblems;

import org.json.JSONObject;

public class JsonCreator {
    public static void main(String[] args) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Name","Shamiksha");
        jsonObject.put("Age",19);
        jsonObject.put("Subject",new String[]{"English","Maths","Science","SST"});
        System.out.println(jsonObject);

    }

}
