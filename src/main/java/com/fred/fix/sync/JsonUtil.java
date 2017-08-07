package com.fred.fix.sync;

import com.google.gson.Gson;

/**
 * @version 1.0
 */
public class JsonUtil {
    private static Gson gson = new Gson();

    public static <T> T parseJson(String response, Class<T> clazz) {

        try {
            return gson.fromJson(response, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toJson(Object object) {

        try {
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}