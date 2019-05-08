/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xmaps;

import static dbviewer.globals.GlobalVariables.CRLF;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class StringMaps {

  public static void main(String[] args) {
    new StringMaps();
  }

  public StringMaps() {
//    getMap(sectormap);
//    getMap(countermap);
//    getMap(npcmap);
  }

  public Map<String, String> map;

  //<editor-fold defaultstate="collapsed" desc="String[] countermap = {">
  String[] countermap = {
    "Hex",
    "CounterType",
    "X",
    "Y",
    "W",
    "H",
    "Squares",
    "LPOS",
    "L01",
    "L02",
    "L03",
    "L04",
    "L05",
    "L06",
    "L07",
    "L08",
    "L09",
    "L10",
    "RPOS",
    "R01",
    "R02",
    "R03",
    "R04",
    "R05",
    "R06",
    "R07",
    "R08",
    "R09",
    "R10"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] npcmap = {">
  String[] npcmap = {
    "Sectors",
    "Subsectors",
    "Systems",
    "Orbits",
    "Starships",
    "Environs",
    "IDs",
    "Names",
    "Race",
    "Sex",
    "Careers",
    "Terms",
    "Age",
    "UPP",
    "AIs",
    "Ships",
    "Vehicles",
    "Weapons"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] sectormap = {">
  String[] sectormap = {
    "Sector",
    "SubSector",
    "System",
    "Star",
    "Name",
    "UWP",
    "SDBs",
    "MaxRons",
    "DefCF",
    "Troops",
    "Pop",
    "Belts",
    "GGs",
    "W",
    "Tonnage",
    "Mult",
    "Fuel",
    "Jump",
    "Destinations"
  };
  //</editor-fold>

  public Map<String, String> getMap() {
    return map;
  }

  public Map<String, String> getMap(String string) {
    // Create a Map.
    map = new HashMap<>();
    String[] strings = null;
    switch (string.toLowerCase()) {
      case "sector": {
        strings = sectormap;
        break;
      }
      case "counter": {
        strings = countermap;
        break;
      }
      case "npc": {
        strings = npcmap;
        break;
      }
      default: {
        //<editor-fold defaultstate="collapsed" desc="JOP">
        {
          String s = "";
          s += "" + CRLF;
          s += "" + CRLF;
          JTextArea jta = new JTextArea(s, 50, 80);
          JScrollPane jsp = new JScrollPane(jta);
          JOptionPane.showMessageDialog(null, jsp);
        }
        //</editor-fold>
        break;
      }
    }
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i].toUpperCase(), strings[i].toLowerCase());
      System.out.println(map.get(strings[i].toUpperCase()));
    }
    System.out.println("");
    return map;
  }

  public Map<String, String> getMap(String[] strings) {
    // Create a Map.
    map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      map.put(strings[i].toUpperCase(), strings[i].toLowerCase());
      System.out.println(map.get(strings[i].toUpperCase()));
    }
    System.out.println("");
    return map;
  }

}
