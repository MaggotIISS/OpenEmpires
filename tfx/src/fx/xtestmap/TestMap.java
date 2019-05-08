package fx.xtestmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import panels.Panel4T5Locator;

public class TestMap {

  public static String output = "";

  /**
   @return the output
   */
  public static String getOutput() {
    return output;
  }

  /**
   @param aOutput the output to set
   */
  public static void setOutput(String aOutput) {
    output = aOutput;
  }

  public static void main(String[] args) {
    new TestMap();
  }

  public TestMap() {
//    super();
    this.CRLF = "\n";
    setCarl();
    setNPC();
//    clearNPC();
    showNPC();
    System.out.println("" + " = " + map.toString());
  }

  public TestMap(Map<String, String> map) {
//    this();
    this.map = map;
//    this.size = size;
  }
  @SuppressWarnings("PackageVisibleField")
  String CRLF;
  //<editor-fold defaultstate="collapsed" desc="String[] keys">
  final String[] keys = new String[]{
    "sector", "subsector", "system", "orbit", "starship", "environ", "id",
    "name", "race", "sex", "career", "terms", "age", "upp",
    "ai", "ship", "vehicle"};
  //</editor-fold>

  Map<String, String> map;

//  int size = 0;
  //<editor-fold defaultstate="collapsed" desc="String[] values">
  String[] values = new String[]{"Spinward Marches", "C Regina",
    "1705 Efate", "4", "Sky Rig", "OK", "Captain",
    "Carl Anderson",
    "Vilani",
    "Male",
    "Navy",
    "4",
    "40",
    "AAAAAA",
    "Omega", "Alpha", "Fasta-550"};

  //</editor-fold>
  public void clearNPC() {
    for (int i = 0; i < keys.length; i++) {
      getMap().put(keys[i], keys[i].toLowerCase());
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final TestMap other = (TestMap) obj;
    if (!Objects.equals(this.CRLF, other.CRLF)) {
      return false;
    }
    if (!Arrays.deepEquals(this.keys, other.keys)) {
      return false;
    }
    if (!Objects.equals(this.map, other.map)) {
      return false;
    }
    if (!Arrays.deepEquals(this.values, other.values)) {
      return false;
    }
    return true;
  }

  /**
   @return the map
   */
  public Map<String, String> getMap() {
    return map;
  }

  /**
   @param map the map to set
   */
  public void setMap(Map<String, String> map) {
    this.map = map;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + Objects.hashCode(this.CRLF);
    hash = 59 * hash + Arrays.deepHashCode(this.keys);
    hash = 59 * hash + Objects.hashCode(this.map);
    hash = 59 * hash + Arrays.deepHashCode(this.values);
    return hash;
  }

  public void setCarl() {
    // Create a Map.
    setMap(new HashMap<>());
//    setSize(keys.length);
    for (int i = 0; i < keys.length; i++) {
      getMap().put(keys[i], values[i]);
    }
  }

  public void setNPC() {
    String sex = "Male";
    try {
      if (Panel4T5Locator.Sex.isSelected()) {
        sex = "Male";
      } else {
        sex = "Female";
      }
      values = new String[]{
        Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim(),
        Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim(),
        Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(),
        "orbit",
        "starship",
        "Open",
        "id",
        Panel4T5Locator.jtf4Word.getText().trim(),
        Panel4T5Locator.jcb4Lang.getSelectedItem().toString().trim(),
        sex,
        Panel4T5Locator.jcb4Career.getSelectedItem().toString().trim(),
        Panel4T5Locator.js4Terms.getValue().toString().trim(),
        "" + ((int) Panel4T5Locator.js4Terms.getValue() * 4 + 18),
        Panel4T5Locator.jtf4UPP.getText().trim(),
        "ai",
        "ship",
        "vehicle"
      };
    } catch (Exception e) {
      System.out.println("118" + " = " + e);
    } finally {
      for (int i = 0; i < keys.length; i++) {
        getMap().put(keys[i], values[i]);
      }
    }
  }

  public void showNPC() {
    setOutput("");
    for (int i = 0; i < keys.length; i++) {
      setOutput(getOutput() + keys[i].toUpperCase() + " : " + getMap().get(
        keys[i]) + CRLF);
    }
    System.out.println(getOutput());
  }

  @Override
  public String toString() {
    return "TestMap{" + "CRLF=" + CRLF + ", keys=" + keys + ", map=" + map
      + ", values=" + values + '}';
  }

}
