package fx.xtestmap;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class CollectionsDemo {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    // Create a List.
    System.out.println("Creating the List...");
    List<String> list = new ArrayList<String>();
    list.add("String one");
    list.add("String two");
    list.add("String three");

    // Print out contents.
    printElements(list);

    // Set a new element at index 0.
    System.out.println("Setting an element...");
    list.set(0, "A new String");
    printElements(list);

    // Search for the newly added String.
    System.out.println("Searching for content...");
    System.out.print("Contains \"A new String\"? ");
    System.out.println(list.contains("A new String"));
    System.out.println("");

    // Create a sublist.
    System.out.println("Creating a sublist...");
    list = list.subList(1, 3);
    printElements(list);

    // Clear all elements.
    System.out.println("Clearing all elements...");
    list.clear();
    printElements(list);

    // Use Java Collections to create the List.
//        List<String> list = new ArrayList<>();
    // Now add observability by wrapping it with ObservableList.
    ObservableList<String> observableList = FXCollections.observableList(list);
    observableList.addListener(new ListChangeListener() {

      @Override
      public void onChanged(ListChangeListener.Change change) {
        System.out.println("Detected a change! ");
        System.out.println("change.toString()" + " = " + change.toString());
      }
    });

    // Changes to the observableList WILL be reported.
    // This line will print out "Detected a change!"
    observableList.add("item one");

    // Changes to the underlying list will NOT be reported
    // Nothing will be printed as a result of the next line.
    list.add("item two");

    System.out.println("Size: " + observableList.size());

  }

  private static void printElements(List<String> list) {
    System.out.println("Size: " + list.size());
    for (Object o : list) {
      System.out.println(o.toString());
    }
    System.out.println("");
  }
}
