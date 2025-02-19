package com.capgeminitraining.day02.practiseproblems;
import org.json.JSONArray;
import org.json.JSONObject;
public class MergeJSONObject {
    public static void main(String[] args) {
        // Creating first JSON Object
        JSONObject obj1 = new JSONObject();
        obj1.put("Name", "Ankit");
        obj1.put("Age", 21);
        obj1.put("Marks", new JSONArray(new int[]{21, 12, 30, 23}));
        obj1.put("Funny", true);
        // Creating second JSON Object
        JSONObject obj2 = new JSONObject();
        obj2.put("Name", "Anshu Priya");
        obj2.put("Age", 22);
        obj2.put("Marks", new JSONArray(new int[]{12, 13, 14, 15}));
        obj2.put("Funny", false);
        obj2.put("City", "Mumbai");

        // Merging JSONObjects
        JSONObject mergedObject = new JSONObject();
        mergedObject.put("Name", obj1.getString("Name") + " & " + obj2.getString("Name"));
        mergedObject.put("Age", obj2.getInt("Age")); // Taking Age from obj2
        mergedObject.put("Funny", obj2.getBoolean("Funny")); // Taking Funny from obj2
        mergedObject.put("City", obj2.getString("City")); // New field

        // Merging Marks arrays
        JSONArray marks = obj1.getJSONArray("Marks");
        JSONArray marks2 = obj2.getJSONArray("Marks");
        for (int i = 0; i < marks2.length(); i++) {
            marks.put(marks2.get(i));
        }
        mergedObject.put("Marks", marks);

        // Printing merged JSON Object
        System.out.println(mergedObject);
    }
}
