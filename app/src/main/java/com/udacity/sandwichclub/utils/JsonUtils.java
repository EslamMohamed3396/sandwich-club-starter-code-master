package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String JSON_INTENT_KEY_NAME = "name";
    private static final String JSON_INTENT_KEY_ALSO_KNOWN = "alsoKnownAs";
    private static final String JSON_INTENT_KEY_INGEDIENTS = "ingredients";
    private static final String JSON_INTENT_KEY_DESCRIPTION = "description";
    private static final String JSON_INTENT_KEY_ORIGIN = "placeOfOrigin";
    private static final String JSON_INTENT_KEY_IMAGE = "image";
    private static final String JSON_INTENT_KEY_MAIN_NAME = "mainName";
    public static Sandwich parseSandwichJson(String json) {
        JSONObject sandwichObject;

        Sandwich sandwich = null;

        List<String> alsoKnownAs = new ArrayList<>();;

        List<String> ingredients = new ArrayList<>();;

        try {
            sandwichObject = new JSONObject(json);

            JSONObject nameOfSand = sandwichObject.optJSONObject(JSON_INTENT_KEY_NAME);

            JSONArray alsoKnownAsOfSand = nameOfSand.optJSONArray(JSON_INTENT_KEY_ALSO_KNOWN);

            JSONArray ingredientArray = sandwichObject.optJSONArray(JSON_INTENT_KEY_INGEDIENTS);

            String descriptionOfSand = sandwichObject.optString(JSON_INTENT_KEY_DESCRIPTION);

            String placeOfOriginOfSand = sandwichObject.optString(JSON_INTENT_KEY_ORIGIN);

            String imageOfSand = sandwichObject.optString(JSON_INTENT_KEY_IMAGE);

            String Name = nameOfSand.optString(JSON_INTENT_KEY_MAIN_NAME);

            for (int i = 0; i < alsoKnownAsOfSand.length(); i++) {
                String knownString = alsoKnownAsOfSand.getString(i);
                    alsoKnownAs.add(knownString);

            }
            for (int i = 0; i < ingredientArray.length(); i++) {
                String ingredientString = ingredientArray.getString(i);
                ingredients.add(ingredientString);
            }

            sandwich = new Sandwich(Name, alsoKnownAs, placeOfOriginOfSand, descriptionOfSand, imageOfSand, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
