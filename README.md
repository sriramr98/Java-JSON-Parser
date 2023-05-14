# Java Reflection-Based JSON Parser

This is a simple Java JSON parser built using Java Reflection. It can serialize and deserialize Java objects to and from JSON format.

> I have created a youtube video explaining the code in detail. You can watch it [here](https://youtu.be/dLDXsq8Nr4o)

## How to Use
To use the JSON parser, simply include the JsonParser class in your Java project. You can then use the toJSON and fromJSON methods to convert your Java objects to and from JSON format.

## Serializing to JSON
To serialize a Java object to JSON format, call the toJSON method and pass in the object you want to serialize:

```java
MyObject obj = new MyObject();
String json = JsonParser.toJSON(obj);
```

This will return a JSON string representing the MyObject instance.

## Deserializing from JSON
To deserialize a JSON string into a Java object, call the fromJSON method and pass in the JSON string and the class of the object you want to deserialize:

```java
MyObject obj = JsonParser.fromJSON(json, MyObject.class);
```

This will return a MyObject instance with its properties set according to the JSON string.

## Example
Here's an example of how to use the JSON parser:

```java
public class Example {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        obj.setId(1);
        obj.setName("John Doe");

        String json = JsonParser.toJSON(obj);

        System.out.println(json);

        MyObject deserializedObj = JsonParser.fromJSON(json, MyObject.class);

        System.out.println(deserializedObj.getName());
    }
}
```

