package com.foodexpress.model.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class JsonHandler {
    public static JsonObject addToJson(Object object, JsonObject json) {
        Gson gson = new Gson();

        JsonObject jsonClone = gson.fromJson(json.toString(), JsonObject.class);

        JsonObject gsonJsonObject;

        String jsonData = gson.toJson(object);

        gsonJsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

        for(Map.Entry<String, JsonElement> entry : gsonJsonObject.entrySet()) {
            jsonClone.add(entry.getKey(), gsonJsonObject.get(entry.getKey()));
        }

        return jsonClone;
    }
}
