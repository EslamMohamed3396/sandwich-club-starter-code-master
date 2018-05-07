package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        JSONObject sandwichObject;

        Sandwich sandwich = null;

        List<String> alsoKnownAs = null;

        List<String> ingredients = null;

        try {
            sandwichObject = new JSONObject(json);

            JSONObject nameOfSand = sandwichObject.getJSONObject("name");

            JSONArray alsoKnownAsOfSand = nameOfSand.getJSONArray("alsoKnownAs");

            JSONArray ingredientArray = sandwichObject.getJSONArray("ingredients");

            String descriptionOfSand = sandwichObject.getString("description");

            String placeOfOriginOfSand = sandwichObject.getString("placeOfOrigin");

            String imageOfSand = sandwichObject.getString("image");

            String Name = nameOfSand.getString("mainName");


            for (int i = 0; i < alsoKnownAsOfSand.length(); i++) {
                String knownString = alsoKnownAsOfSand.getString(i);
                    alsoKnownAs = new ArrayList<>();
                    alsoKnownAs.add(knownString);

            }
            for (int i = 0; i < ingredientArray.length(); i++) {
                String ingredientString = ingredientArray.getString(i);

                ingredients = new ArrayList<>();
                ingredients.add(ingredientString);
            }

            sandwich = new Sandwich(Name, alsoKnownAs, placeOfOriginOfSand, descriptionOfSand, imageOfSand, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
