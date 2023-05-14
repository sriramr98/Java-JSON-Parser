package org.example;

import org.json.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JsonParser {

    public static <T> String toJSON(T instance) {

        JSONObject json = new JSONObject();

        for (var field : instance.getClass().getDeclaredFields()) {
            String name = field.getName();
            try {
                field.setAccessible(true);
                Object value = field.get(instance);
                json.put(name, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return json.toString();
    }

    public static <T> T toJSON(String json, Class<T> tClass) {
       // create the instance T
        JSONObject jsonObj = new JSONObject(json);
       // we need to loop through json properties

        try {
            Constructor<T> constructor = tClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();
            return parseJSON(jsonObj, instance);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    private static <T> T parseJSON(JSONObject json, T instance) throws IllegalAccessException {
       for (var field : instance.getClass().getDeclaredFields()) {
         String name = field.getName();

         if (json.has(name)) {
             field.setAccessible(true);
             field.set(instance, json.get(name));
         }
       }

       return instance;
    }

}
