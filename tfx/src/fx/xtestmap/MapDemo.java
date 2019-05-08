package fx.xtestmap;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

  public static void main(String[] args) {

    // Create a Map.
    Map<String, String> map = new HashMap<String, String>();
    map.put("apple", "fruit");
    map.put("carrot", "vegetable");
    System.out.println("Size: " + map.size());
    System.out.println("Empty? " + map.isEmpty());

    // Pass in keys; print out values.
    System.out.println("Passing in keys and printing out values...");
    System.out.println("Key is apple, value is: " + map.get("apple"));
    System.out.println("Key is carrot, value is: " + map.get("carrot"));
    System.out.println("");

    // Check keys and values.
    System.out.println("Inspecting keys and values:");
    System.out.println("Contains key \"apple\"? " + map.containsKey("apple"));
    System.out.println("Contains key \"carrot\"? " + map.containsKey("carrot"));
    System.out.println("Contains key \"fruit\"? " + map.containsKey("fruit"));
    System.out.println("Contains key \"vegetable\"? " + map.containsKey(
      "vegetable"));
    System.out
      .println("Contains value \"apple\"? " + map.containsValue("apple"));
    System.out.println("Contains value \"carrot\"? " + map.containsValue(
      "carrot"));
    System.out
      .println("Contains value \"fruit\"? " + map.containsValue("fruit"));
    System.out.println("Contains value \"vegetable\"? " + map.containsValue(
      "vegetable"));
    System.out.println("");

    // Remove objects from the map.
    System.out.println("Removing apple from the map...");
    map.remove("apple");
    System.out.println("Size: " + map.size());
    System.out.println("Contains key \"apple\"? " + map.containsKey("apple"));
    System.out.println("Invoking map.clear()...");
    map.clear();
    System.out.println("Size: " + map.size());
  }
}
