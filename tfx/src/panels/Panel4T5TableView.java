/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.StarGen;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import static dbviewer.globals.GlobalVariables.TAB;
import static dbviewer.globals.GlobalVariables._JS;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static panels.Panel4T5Scripting.CSV;

/**
 <p>
 @author Mark Ferguson
 */
public class Panel4T5TableView extends Panel4 {

  static JPanel jp;
  static JFrame jf;
  static String col1 = "";
  static String roww = "";
  static String title = "";
  static String[] table = null;
  static ActionEvent ae;
  static String dname = "";
  static String fname = "";
  static File f = null;
  /**
   args
   */
  public static String[] args = {
    "SDBSquadrons", "9", "9", "100"
  };
  static String folder = "";
  static String name = "";
  static String ext = "";
  static String search = "String[]";
  static String out = "";

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4T5TableView(args);
    jf = new Frame4(jp);
    jf.setVisible(true);
  }

  Panel4T5TableView() {
    super();
    initComponents();
    sortJCB();
    jComboBox1.setSelectedIndex(0);
    addFiles();
  }

  /**
   Creates new form Panel4T5TableView
   <p>
   @param args info for startup
   */
  Panel4T5TableView(String[] args) {
    this();
    if (args != null) {
      if (args.length > 0) {
        jcb.setSelectedItem(args[0]);
      }
      title = jcb.getSelectedItem().toString();
      if (args.length > 1) {
        col1 = args[1];
        col.setText(args[1]);
      }
      if (args.length > 2) {
        roww = args[2];
        row.setText(args[2]);
      }
      if (args.length > 3) {
        result.setText(args[3]);
      }
      calc();
    }
    calcRowMod();
  }

  private void catalog() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
//    writeXML();
    String[] txt = jta.getText().split(CRLF);;
    String lines = "";
    String row;
    for (int y = 2; y < txt.length; y++) {
      row = "";
      String[] col = txt[y].split(TAB);
      for (int x = 0; x < col.length; x++) {
        row += "\"" + col[x] + "\"";
        if (x < (col.length - 1)) {
          row += ",";
        } else {
          row += CRLF;
        }
      }
      lines += row;
    }
    System.out.println(lines);
    Panel4T5Scripting.Folder.setSelectedItem("Catalogs");
    Panel4T5Scripting.CSV.setText(lines);
    String folder = _JS + FS + Panel4T5Scripting.Folder.getSelectedItem()
      .toString();
//    Panel4T5Scripting.Name.setText(folder.substring(folder.lastIndexOf(FS)));
    JComboBox t = new JComboBox();
    switch (jLabel1.getText()) {
      case "jcb": {
        t = jcb;
        break;
      }
      case "jComboBox1": {
        t = jcb1;
        break;
      }
      case "jComboBox2": {
        t = jComboBox2;
        break;
      }
    }
    Panel4T5Scripting.Name.setText(t.getSelectedItem().toString());
    GlobalMethods.saveTextFile(folder, t.getSelectedItem().toString(),
      ".txt",
      lines);
    GlobalMethods.saveTextFile(T5, "CSV", ".csv",
      lines);
    Panel4T5Scripting.csv2WebTable(folder);
    Panel4T5Scripting.saveXML(folder, false);
    Panel4T5Scripting.writeXML();
    Panel4T5Scripting.showFullNames();
    CSV.setText(lines);
  }

  /**
   <p>
   @return result of calculation
   */
  public static String getResult() {
    result.setText("X");
    calc();
    return result.getText();
  }

  /**
   <p>
   @param r row value
   @param c column value
   @return result of table @ r,c
   */
  public static String getResult(String r, String c) {
    result.setText("X");
    row.setText(r);
    col.setText(c);
    calc();
    return result.getText();
  }

  /**
   <p>
   @param tabl table to select
   @param c    column value
   @param r    row value
   @return result of table @ r,c
   */
  public static String getResult(String tabl, String c, String r) {
    result.setText("X");
    jcb.setSelectedItem(tabl);
    table = getTable();
    col.setText(c);
    row.setText(r);
    calc();
    return result.getText();
  }

  static String getMod() {
    return ResMod.getText();
  }

  static void setMod(String mod) {
    rowmod.setText(mod);
  }

  static String getTableData(String[] string) {
    new Panel4T5TableView(string);
    return jta.getText();
  }

  static void calcRowMod() {
    int mod = 0;
    int val = 0;
    int len = Integer.parseInt(table[0]);
    int colmod = Integer.parseInt(rowmod.getText());
    String s = "";
    Len.setText("" + len);
    for (int j = len + 1; j < table.length; j += len) {
      if (row.getText().equals(table[j])) {
        mod = j + (len * colmod);
//        System.out.println("" + " = " + table[mod]);
        ModRes.setText(table[mod]);
        if (table != null) {
          if (ModRes.getText() != "" & col.getText() != "") {
            ResMod.setText(GlobalMethods.getStringFromTable(table[1], ModRes
              .getText(), col.getText(), table));
          }
        }
        break;
      }
    }
  }

  static void calcColMod() {
    int mod = 0;
    int val = 0;
    int len = Integer.parseInt(table[0]);
    int colmod = Integer.parseInt(rowmod.getText());
    String s = "";
    Len.setText("" + len);
    for (int j = len + 1; j < table.length; j += len) {
      if (row.getText().equals(table[j])) {
        mod = j + (len * colmod);
//        System.out.println("" + " = " + table[mod]);
        ModRes.setText(table[mod]);
        if (table != null) {
          if (ModRes.getText() != "" & col.getText() != "") {
            ResMod.setText(GlobalMethods.getStringFromTable(table[1], ModRes
              .getText(), col.getText(), table));
          }
        }
        break;
      }
    }
  }

  private static void calc() {
    jta.setText("");
    GlobalMethods.showTable(jta, title, table);
    if (table != null) {
      if (row.getText() != "" & col.getText() != "") {
        result.setText(GlobalMethods.getStringFromTable(table[1], row.getText(),
          col.getText(), table));
      }
      calcRowMod();
      calcColMod();
    }
  }

  private void comboChange() {
    jta.setText("");
    table = getTable();
    title = jcb.getSelectedItem().toString();
    GlobalMethods.showTable(jta, title, table);
    jLabel1.setText("jcb");
  }

  private static String[] getTable() {
    try {
      switch (jcb.getSelectedItem().toString()) {
        case "TechLevelModifiers": {
          table = GlobalVariables.TechLevelModifiers;
          break;
        }
        case "ResourcesInfrastructureCultureRatings": {
          table = GlobalVariables.ResourcesInfrastructureCultureRatings;
          break;
        }
        case "SDBSquadrons": {
          table = GlobalVariables.SDBSquadrons;
          break;
        }
        case "StreamlineValue": {
          table = GlobalVariables.StreamlineValue;
          break;
        }
        case "BaseJumpRating": {
          table = GlobalVariables.BaseJumpRating;
          break;
        }
        case "BaseSquadronCost": {
          table = GlobalVariables.BaseSquadronCost;
          break;
        }
        case "StreamlineCostMultiplier": {
          table = GlobalVariables.StreamlineCostMultiplier;
          break;
        }
        case "MaxStarshipSquadrons": {
          table = GlobalVariables.MaxStarshipSquadrons;
          break;
        }
        case "DefenceBattalionsCombatFactor": {
          table = GlobalVariables.DefenceBattalionsCombatFactor;
          break;
        }
        case "CombatFactorCapacity": {
          table = GlobalVariables.CombatFactorCapacity;
          break;
        }
        case "InitialProduction": {
          table = GlobalVariables.InitialProduction;
          break;
        }
        case "TroopUnitCost": {
          table = GlobalVariables.TroopUnitCost;
          break;
        }
        case "TroopUnitSize": {
          table = GlobalVariables.TroopUnitSize;
          break;
        }
        case "PlanningFactor": {
          table = GlobalVariables.PlanningFactor;
          break;
        }
        case "TacticalFactor": {
          table = GlobalVariables.TacticalFactor;
          break;
        }
        case "RepairPoints": {
          table = GlobalVariables.RepairPoints;
          break;
        }
        case "AdmiralsInCombat": {
          table = GlobalVariables.AdmiralsInCombat;
          break;
        }
        case "PreparednessLevel": {
          table = GlobalVariables.PreparednessLevel;
          break;
        }
        case "ReinforcementLevel": {
          table = GlobalVariables.ReinforcementLevel;
          break;
        }
        case "ReinforcementLevel1": {
          table = GlobalVariables.ReinforcementLevelOne;
          break;
        }
        case "ReinforcementLevel2": {
          table = GlobalVariables.ReinforcementLevelTwo;
          break;
        }
        case "ReinforcementLevel3": {
          table = GlobalVariables.ReinforcementLevelThree;
          break;
        }
        case "RequiredRefuellingTimes": {
          table = GlobalVariables.RequiredRefuellingTimes;
          break;
        }
        case "StarportRefuellingTable": {
          table = GlobalVariables.StarportRefuellingTable;
          break;
        }
        case "SpaceCombatResultsTable": {
          table = GlobalVariables.SpaceCombatResultsTable;
          break;
        }
        case "SDBVsSquadronTable": {
          table = GlobalVariables.SDBVsSquadronTable;
          break;
        }
        case "SquadronVsSDBTable": {
          table = GlobalVariables.SquadronVsSDBTable;
          break;
        }
        case "TLCombatModifiers": {
          table = GlobalVariables.TLCombatModifiers;
          break;
        }
        case "AtmosphereModifiers": {
          table = GlobalVariables.AtmosphereModifiers;
          break;
        }
        case "SurfaceBombingTable": {
          table = GlobalVariables.SurfaceBombingTable;
          break;
        }
        case "PercentageLossTable": {
          table = GlobalVariables.PercentageLossTable;
          break;
        }
        case "TroopCombatResultsTable": {
          table = GlobalVariables.TroopCombatResultsTable;
          break;
        }
        case "Magnitude": {
          table = StarGen.Magnitude;
          break;
        }
        case "Luminosity": {
          table = StarGen.Luminosity;
          break;
        }
        case "Temp": {
          table = StarGen.Temp;
          break;
        }
        case "Radii": {
          table = StarGen.Radii;
          break;
        }
        case "Masses": {
          table = StarGen.Masses;
          break;
        }
        case "WhiteDwarfs": {
          table = StarGen.WhiteDwarfs;
          break;
        }
        case "HabitableDistance": {
          table = StarGen.HabitableDistance;
          break;
        }
        case "Distance": {
          table = StarGen.Distance;
          break;
        }
        case "Planets": {
          table = StarGen.Planets;
          break;
        }
        case "Moons": {
          table = StarGen.Moons;
          break;
        }
        case "Zones": {
          table = StarGen.Zones;
          break;
        }
        case "TradeCode": {
          table = Panel4ListTextOld.TradeCode;
          break;
        }
        case "StarPort": {
          table = Panel4ListTextOld.StarPort;
          break;
        }
        case "ResourceTradeBenefit": {
          table = Panel4ListTextOld.ResourceTradeBenefit;
          break;
        }
        case "StarportMultipliers": {
          table = Panel4ListTextOld.StarportMultipliers;
          break;
        }
        case "TotalDemand": {
          table = Panel4ListTextOld.TotalDemand;
          break;
        }
        case "stage": {
          table = Panel4T5ArmorMaker.stage;
          break;
        }
        case "burden": {
          table = Panel4T5ArmorMaker.burden;
          break;
        }
        case "type": {
          table = Panel4T5ArmorMaker.type;
          break;
        }
        case "user": {
          table = Panel4T5ArmorMaker.user;
          break;
        }
        case "armortypes": {
          table = Panel4T5ArmorMaker.armortypes;
          break;
        }
        case "body": {
          table = Panel4T5ArmorMaker.body;
          break;
        }
        case "item": {
          table = Panel4T5ArmorMaker.item;
          break;
        }
        case "descriptor": {
          table = Panel4T5ArmorMaker.descriptor;
          break;
        }
        case "Categories": {
          table = Panel4T5GunMaker.Categories;
          break;
        }
        case "EffectsArmorDamage": {
          table = Panel4T5GunMaker.EffectsArmorDamage;
          break;
        }
        case "WeaponSkillStat": {
          table = Panel4T5GunMaker.WeaponSkillStat;
          break;
        }
        case "WeaponRanges": {
          table = Panel4T5GunMaker.WeaponRanges;
          break;
        }
        case "WeaponDescriptors": {
          table = Panel4T5GunMaker.WeaponDescriptors;
          break;
        }
        case "BurdenStage": {
          table = Panel4T5GunMaker.BurdenStage;
          break;
        }
        case "Portability": {
          table = Panel4T5GunMaker.Portability;
          break;
        }
        case "SpecialEffects": {
          table = Panel4T5GunMaker.SpecialEffects;
          break;
        }
        case "Options": {
          table = Panel4T5GunMaker.Options;
          break;
        }
        case "Controls": {
          table = Panel4T5GunMaker.Controls;
          break;
        }
        case "SpectralSize": {
          table = Panel4T5System.SpectralSize;
          break;
        }
        case "SystemStars": {
          table = Panel4T5System.SystemStars;
          break;
        }
        case "gravlimit": {
          table = Panel4T5System.gravlimit;
          break;
        }
        case "jumplimit": {
          table = Panel4T5System.jumplimit;
          break;
        }
        case "manlimit": {
          table = Panel4T5System.manlimit;
          break;
        }
        case "GGs": {
          table = Panel4T5System.GGs;
          break;
        }
        case "Placement": {
          table = Panel4T5System.Placement;
          break;
        }
      }
    } catch (Exception e) {
//      System.out.println(e);
    }
    return table;
  }

  @SuppressWarnings("unchecked")
  private void sortJCB() {
    Object[] parts = new Object[jcb.getModel().getSize()];
    for (int j = 0; j < jcb.getModel().getSize(); j++) {
      parts[j] = jcb.getModel().getElementAt(j).toString();
    }
    Arrays.sort(parts);
//    for (int j = 0; j < parts.length; j++) {
//      System.out.println("" + " = " + parts[j]);
//    }
    @SuppressWarnings("unchecked")
    DefaultComboBoxModel dcbm = new DefaultComboBoxModel(parts);
    jcb.setModel(dcbm);
//    System.out.println("jcb.getItemCount()" + " = " + jcb.getItemCount());
  }

  private void jcb1Action(ActionEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    String[][] stringArrays = new String[][]{
      Panel4T5Locator.Alleg,
      Panel4T5Locator.Atmo,
      Panel4T5Locator.B,
      Panel4T5Locator.D10Limit,
      Panel4T5Locator.D100Limit,
      Panel4T5Locator.D1000Limit,
      Panel4T5Locator.GGs,
      Panel4T5Locator.Govt,
      Panel4T5Locator.Hab,
      Panel4T5Locator.Hydro,
      Panel4T5Locator.Law,
      Panel4T5Locator.MainworldType,
      Panel4T5Locator.N,
      Panel4T5Locator.NIL,
      Panel4T5Locator.Placement,
      Panel4T5Locator.Pop,
      Panel4T5Locator.Remarks,
      Panel4T5Locator.Size,
      Panel4T5Locator.StarColor,
      Panel4T5Locator.StarSize,
      Panel4T5Locator.Tech,
      Panel4T5Locator.Alleg,
      Panel4T5Locator.Atmo,
      Panel4T5Locator.B,
      Panel4T5Locator.D1000Limit,
      Panel4T5Locator.D100Limit,
      Panel4T5Locator.D10Limit,
      Panel4T5Locator.GGs,
      Panel4T5Locator.Govt,
      Panel4T5Locator.Hab,
      Panel4T5Locator.Hydro,
      Panel4T5Locator.Law,
      Panel4T5Locator.MainworldType,
      Panel4T5Locator.N,
      Panel4T5Locator.NIL,
      Panel4T5Locator.Placement,
      Panel4T5Locator.Pop,
      Panel4T5Locator.Remarks,
      Panel4T5Locator.Size,
      Panel4T5Locator.StarColor,
      Panel4T5Locator.StarSize,
      Panel4T5Locator.Tech
    /*
     GlobalVariables.AdmiralsInCombat,
     GlobalVariables.AtmosphereModifiers,
     GlobalVariables.BaseJumpRating,
     GlobalVariables.BaseSquadronCost,
     GlobalVariables.brightgiants,
     GlobalVariables.CombatFactorCapacity,
     GlobalVariables.DefenceBattalionsCombatFactor,
     GlobalVariables.Hab,
     GlobalVariables.HabZones,
     GlobalVariables.InitialProduction,
     GlobalVariables.MaxStarshipSquadrons,
     GlobalVariables.mainsequence,
     GlobalVariables.PercentageLossTable,
     GlobalVariables.PlanningFactor,
     GlobalVariables.PreparednessLevel,
     GlobalVariables.planetaryorbitnum,
     GlobalVariables.planetaryorbitnumau,
     GlobalVariables.planetaryorbitnummkm,
     GlobalVariables.ReinforcementLevel,
     GlobalVariables.ReinforcementLevelOne,
     GlobalVariables.ReinforcementLevelThree,
     GlobalVariables.ReinforcementLevelTwo,
     GlobalVariables.RepairPoints,
     GlobalVariables.RequiredRefuellingTimes,
     GlobalVariables.ResourcesInfrastructureCultureRatings,
     GlobalVariables.SDBSquadrons,
     GlobalVariables.SDBVsSquadronTable,
     GlobalVariables.SpaceCombatResultsTable,
     GlobalVariables.SquadronVsSDBTable,
     GlobalVariables.StarportRefuellingTable,
     GlobalVariables.StreamlineCostMultiplier,
     GlobalVariables.StreamlineValue,
     GlobalVariables.SurfaceBombingTable,
     GlobalVariables.SystemContents,
     GlobalVariables.SystemFeature
     */
    };
    String old = jta.getText();
    jta.setText("");
    String[] array = null;
    String string = "";
    String fname = "";
    for (int j = 0; j < stringArrays.length; j++) {
      array = new String[stringArrays[j].length];
      array = stringArrays[j];
      fname = jcb1.getItemAt(j);
      string = fname + CRLF;
      string += GlobalMethods.comment("-", 20);
      for (int k = 1; k < array.length; k++) {
        string += array[k] + "\t";
        try {
          int num = Integer.parseInt(array[0]);
          if (k % num == 0) {
            string += CRLF;
          }

        } catch (Exception e) {
          {
            String s = e.toString();
            System.out.println(s);
          }
        } finally {
          System.out.println(stringArrays[j].toString());
        }
      }
      GlobalMethods.saveTextFile(GlobalVariables.CSV, fname, ".txt", string);
      System.out.println("" + j + "\t" + string);
      if (jcb1.getSelectedIndex() == j) {
        jta.setText(string);
      }
    }
    jLabel1.setText("jComboBox1");
  }

  private void jComboBox1Action(ActionEvent evt) {
    addFiles();
  }

  private void addFiles() {
    fname = "";
    switch (jComboBox1.getSelectedItem().toString()) {
      case "CSV": {
        dname = "C:/T5/_CSV";
        break;
      }
      case "TEXT": {
        dname = "C:/T5/_CSV/TEXT";
        break;
      }
      case "Panels": {
        dname = "C:/T5/TFX/src/panels";
        break;
      }
      case "Files": {
        dname = "C:/T5/TFX/src/panels";
        JFileChooser jfc = new JFileChooser(dname);
        jfc.showOpenDialog(jp);
        String s = jfc.getSelectedFile().toString();
        folder = jfc.getCurrentDirectory().toString();
        if (s.contains(".")) {
          name = s.substring(s.lastIndexOf(FS) + 1, s.lastIndexOf("."));
          ext = s.substring(s.lastIndexOf("."));
        } else {
          name = s;
          ext = "";
        }
        findStrings(folder, name, ext, search, out);
        break;
      }
    }
    try {
      f = new File(dname);
      DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
      String[] list = f.list();
      for (String list1 : list) {
        f = new File(fname + FS + list1);
        if (!f.isDirectory() & !f.toString().endsWith(".form")) {
          dcbm.addElement(list1);
        }
      }
      jComboBox2.setModel(dcbm);
    } catch (Exception e) {
    } finally {
    }
  }

  private void jComboBox2Action(ActionEvent evt) {
    fname = jComboBox2.getSelectedItem().toString();
    f = new File(dname + FS + fname);
    if (f.toString().endsWith(".csv")) {
      jta.setText(f.toString() + CRLF
        + GlobalMethods.comment("-", 20)
        + GlobalMethods.loadTextFile(f.toString()));
    } else if (f.toString().endsWith(".txt")) {
      jta.setText(GlobalMethods.loadTextFile(f.toString()));
    } else {
      jta.setText(f.toString() + CRLF
        + GlobalMethods.comment("-", 20)
        + GlobalMethods.loadTextFile(f.toString()));
    }
    jLabel1.setText("jComboBox2");
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    Len = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    ModRes = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();
    col = new javax.swing.JTextField();
    row = new javax.swing.JTextField();
    l4row = new javax.swing.JLabel();
    l4col = new javax.swing.JLabel();
    l4res = new javax.swing.JLabel();
    result = new javax.swing.JTextField();
    b4calc = new javax.swing.JButton();
    jcb = new javax.swing.JComboBox();
    rowmod = new javax.swing.JTextField();
    l4rowmod = new javax.swing.JLabel();
    ResMod = new javax.swing.JTextField();
    l4modres = new javax.swing.JLabel();
    colmod = new javax.swing.JTextField();
    l4colmod = new javax.swing.JLabel();
    l4catalog = new javax.swing.JLabel();
    jcb1 = new javax.swing.JComboBox<>();
    jLabel1 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox<>();
    jComboBox2 = new javax.swing.JComboBox<>();

    Len.setText("1");
    Len.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LenActionPerformed(evt);
      }
    });

    jLabel5.setBackground(new java.awt.Color(0, 0, 0));
    jLabel5.setForeground(java.awt.Color.lightGray);
    jLabel5.setText("x");
    jLabel5.setOpaque(true);
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    ModRes.setText("1");
    ModRes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ModResActionPerformed(evt);
      }
    });

    jLabel6.setBackground(new java.awt.Color(0, 0, 0));
    jLabel6.setForeground(java.awt.Color.lightGray);
    jLabel6.setText("=");
    jLabel6.setOpaque(true);
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    setBackground(new java.awt.Color(0, 0, 0));
    setForeground(java.awt.Color.lightGray);
    setOpaque(true);

    jta.setColumns(20);
    jta.setRows(5);
    jScrollPane1.setViewportView(jta);

    col.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    col.setToolTipText("Left/Right");
    col.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colActionPerformed(evt);
      }
    });

    row.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    row.setToolTipText("Up/Down");
    row.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rowActionPerformed(evt);
      }
    });

    l4row.setBackground(new java.awt.Color(0, 0, 0));
    l4row.setForeground(java.awt.Color.lightGray);
    l4row.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4row.setText("Row");
    l4row.setOpaque(true);

    l4col.setBackground(new java.awt.Color(0, 0, 0));
    l4col.setForeground(java.awt.Color.lightGray);
    l4col.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4col.setText("Column");
    l4col.setOpaque(true);

    l4res.setBackground(new java.awt.Color(0, 0, 0));
    l4res.setForeground(java.awt.Color.lightGray);
    l4res.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4res.setText("Result");
    l4res.setOpaque(true);

    result.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    b4calc.setText("calc");
    b4calc.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        b4calcActionPerformed(evt);
      }
    });

    jcb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TechLevelModifiers", "ResourcesInfrastructureCultureRatings", "SDBSquadrons", "StreamlineValue", "BaseJumpRating", "BaseSquadronCost", "StreamlineCostMultiplier", "MaxStarshipSquadrons", "DefenceBattalionsCombatFactor", "CombatFactorCapacity", "InitialProduction", "TroopUnitCost", "TroopUnitSize", "PlanningFactor", "TacticalFactor", "RepairPoints", "AdmiralsInCombat", "PreparednessLevel", "ReinforcementLevel", "ReinforcementLevel1", "ReinforcementLevel2", "ReinforcementLevel3", "RequiredRefuellingTimes", "StarportRefuellingTable", "SpaceCombatResultsTable", "SDBVsSquadronTable", "SquadronVsSDBTable", "TLCombatModifiers", "AtmosphereModifiers", "SurfaceBombingTable", "PercentageLossTable", "TroopCombatResultsTable", "Magnitude", "Luminosity", "Temp", "Radii", "Masses", "WhiteDwarfs", "HabitableDistance", "Distance", "Planets", "Moons", "Zones", "TradeCode", "StarPort", "ResourceTradeBenefit", "StarportMultipliers", "TotalDemand", "stage", "burden", "type", "user", "armortypes", "body", "item", "descriptor", "Categories", "EffectsArmorDamage", "WeaponSkillStat", "WeaponRanges", "WeaponDescriptors", "BurdenStage", "Portability", "SpecialEffects", "Options", "Controls", "SpectralSize", "SystemStars", "gravlimit", "jumplimit", "manlimit", "GGs", "Placement" }));
    jcb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jcbMouseClicked(evt);
      }
    });
    jcb.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbActionPerformed(evt);
      }
    });

    rowmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    rowmod.setText("0");
    rowmod.setToolTipText("Up/Down");
    rowmod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        rowmodActionPerformed(evt);
      }
    });

    l4rowmod.setBackground(new java.awt.Color(0, 0, 0));
    l4rowmod.setForeground(java.awt.Color.lightGray);
    l4rowmod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4rowmod.setText("RowMod");
    l4rowmod.setOpaque(true);
    l4rowmod.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4rowmodMouseClicked(evt);
      }
    });

    ResMod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    ResMod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ResModActionPerformed(evt);
      }
    });

    l4modres.setBackground(new java.awt.Color(0, 0, 0));
    l4modres.setForeground(java.awt.Color.lightGray);
    l4modres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4modres.setText("=");
    l4modres.setOpaque(true);
    l4modres.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4modresMouseClicked(evt);
      }
    });

    colmod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    colmod.setText("0");
    colmod.setToolTipText("Left/Right");
    colmod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        colmodActionPerformed(evt);
      }
    });

    l4colmod.setBackground(new java.awt.Color(0, 0, 0));
    l4colmod.setForeground(java.awt.Color.lightGray);
    l4colmod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4colmod.setText("ColMod");
    l4colmod.setOpaque(true);
    l4colmod.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4colmodMouseClicked(evt);
      }
    });

    l4catalog.setForeground(java.awt.Color.green);
    l4catalog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    l4catalog.setText("Catalog");
    l4catalog.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4catalogMouseClicked(evt);
      }
    });

    jcb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alleg", "Atmo", "B", "D10Limit", "D100Limit", "D1000Limit", "GGs", "Govt", "Hab", "Hydro", "Law", "MainworldType", "N", "NIL", "Placement", "Pop", "Remarks", "Size", "StarColor", "StarSize", "Tech", "Alleg", "Atmo", "B", "D1000Limit", "D100Limit", "D10Limit", "GGs", "Govt", "Hab", "Hydro", "Law", "MainworldType", "N", "NIL", "Placement", "Pop", "Remarks", "Size", "StarColor", "StarSize", "Tech" }));
    jcb1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb1ActionPerformed(evt);
      }
    });

    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("jcb");

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSV", "TEXT", "Panels", "Files" }));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    jComboBox2.setMaximumRowCount(30);
    jComboBox2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(l4res)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l4modres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ResMod, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(l4col, javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(l4row))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(col, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(row))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(l4colmod)
                  .addComponent(l4rowmod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(rowmod)
                  .addComponent(colmod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(layout.createSequentialGroup()
                .addComponent(b4calc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jcb, 0, 1, Short.MAX_VALUE)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(l4catalog, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 242, Short.MAX_VALUE)))
        .addGap(0, 0, 0))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ResMod, col, colmod, result, row, rowmod});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l4col, l4res, l4row});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l4colmod, l4modres, l4rowmod});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(col, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(l4col)
              .addComponent(colmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(l4colmod))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(row, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l4row))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rowmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(l4rowmod)
                .addComponent(l4catalog)
                .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(l4res)
              .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ResMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(l4modres)
              .addComponent(b4calc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1)
              .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ResMod, col, colmod, result, row, rowmod});

  }// </editor-fold>//GEN-END:initComponents

  private void b4calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4calcActionPerformed
    calc();
  }//GEN-LAST:event_b4calcActionPerformed

  private void colActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colActionPerformed
    calc();
  }//GEN-LAST:event_colActionPerformed

  private void rowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowActionPerformed
    calc();
  }//GEN-LAST:event_rowActionPerformed

  private void jcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbActionPerformed
    comboChange();
  }//GEN-LAST:event_jcbActionPerformed

  private void rowmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowmodActionPerformed
    calcRowMod();
  }//GEN-LAST:event_rowmodActionPerformed

  private void l4rowmodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4rowmodMouseClicked
    calcRowMod();
  }//GEN-LAST:event_l4rowmodMouseClicked

  private void LenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LenActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_LenActionPerformed

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    calcRowMod();
  }//GEN-LAST:event_jLabel5MouseClicked

  private void ModResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModResActionPerformed
    calcRowMod();
  }//GEN-LAST:event_ModResActionPerformed

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    calcRowMod();
  }//GEN-LAST:event_jLabel6MouseClicked

  private void ResModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResModActionPerformed
    calcRowMod();
  }//GEN-LAST:event_ResModActionPerformed

  private void l4modresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4modresMouseClicked
    calcRowMod();
  }//GEN-LAST:event_l4modresMouseClicked

  private void colmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colmodActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_colmodActionPerformed

  private void l4colmodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4colmodMouseClicked
    calcColMod();
  }//GEN-LAST:event_l4colmodMouseClicked

  private void l4catalogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4catalogMouseClicked
    catalog();
  }//GEN-LAST:event_l4catalogMouseClicked

  private void jcbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMouseClicked
    MouseEvent me = null;
    if (evt.getClickCount() > 1) {
      for (int item = 0; item < jcb.getItemCount(); item++) {
        jcb.setSelectedIndex(item);
        l4catalogMouseClicked(me);
      }
    }
//    catalog();
  }//GEN-LAST:event_jcbMouseClicked

  private void jcb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb1ActionPerformed
    jcb1Action(evt);
  }//GEN-LAST:event_jcb1ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    jComboBox1Action(evt);
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
    jComboBox2Action(evt);
  }//GEN-LAST:event_jComboBox2ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JTextField Len;
  private static javax.swing.JTextField ModRes;
  private static javax.swing.JTextField ResMod;
  private static javax.swing.JButton b4calc;
  private static javax.swing.JTextField col;
  private static javax.swing.JTextField colmod;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JComboBox<String> jComboBox2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  static javax.swing.JComboBox jcb;
  private javax.swing.JComboBox<String> jcb1;
  static javax.swing.JTextArea jta;
  private javax.swing.JLabel l4catalog;
  private javax.swing.JLabel l4col;
  private javax.swing.JLabel l4colmod;
  private javax.swing.JLabel l4modres;
  private javax.swing.JLabel l4res;
  private javax.swing.JLabel l4row;
  private javax.swing.JLabel l4rowmod;
  private static javax.swing.JTextField result;
  private static javax.swing.JTextField row;
  private static javax.swing.JTextField rowmod;
  // End of variables declaration//GEN-END:variables

  static void addStrings() {
    folder = "C:/T5/TFX/src/panels";
    name = "Panel4T5Locator";
    ext = "java";
    search = "String[]";
    findStrings(folder, name, ext, search, out);
  }

  static void findStrings(String folder, String name, String ext, String search,
    String out) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    String[] lines;
    lines = GlobalMethods.loadTextFile(folder, name, ext).split(CRLF);;
    out = "//\t" + name + CRLF;
    int start;
    String line = "";
    for (int i = 0; i < lines.length; i++) {
      line = lines[i].trim();
//      if (line.contains("public")) {
      if (line.contains(search)) {
        if (!line.startsWith("//")) {
          if (!line.contains("public static void main")) {
            start = line.indexOf(search) + search.length();
            line = line.substring(start).trim();
            out += line + "\t" + i + CRLF;
          }
        }
      }
//      }
    }
    String[] outs = out.split(CRLF);;
    Arrays.sort(outs);
    out = "";
    for (int i = 0; i < outs.length; i++) {
      if (!outs[i].startsWith("//")) {
        String[] lined = outs[i].replace(";", " ").replace("{", " ").replace(
          "[]",
          " ").replace(")", " ").split(" ");
        out += name + "." + lined[0] + CRLF;
      }
    }
    Arrays.sort(outs);
    GlobalMethods.saveTextFile(GlobalVariables.CSV + FS + "TEXT", name, "txt",
      out);
    listStrings(out);
  }

  private static void listStrings(String out) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    String[] lines = out.split(CRLF);;
    String txt = "";
    for (int i = 0; i < lines.length; i++) {
      if (!(name + ".").equals(lines[i])) {
        txt += lines[i] + CRLF;
      }
    }
    String s = "" + showData(txt);
    jta.setText(s);
    String[] strings = s.split(CRLF);;
    showIt();
  }

  private static String showData(String txt) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    String[] lines = txt.split(CRLF);;
    String s = "";
    for (int j = 0; j < lines.length; j++) {
      s += "//" + lines[j] + CRLF;
      s += "System.out.println(" + lines[j] + ");" + CRLF;
      s += "for(int i=0; i<" + lines[j] + ".length;i++) {" + CRLF;
      s += "  System.out.println(" + lines[j] + "[i]);" + CRLF;
      s += "}" + CRLF;
      s += "System.out.println();" + CRLF;
      s += "//" + GlobalMethods.comment("-", 20) + CRLF;
    }
    return s;
  }

  private static void showIt() {
////Panel4T5CounterMaker.args
//for(int i=0; i<Panel4T5CounterMaker.args.length;i++) {
//System.out.println(Panel4T5CounterMaker.args[i]);
//}
//System.out.println();
////--------------------
//
////Panel4T5CounterMaker.backdetails
//for(int i=0; i<Panel4T5CounterMaker.backdetails.length;i++) {
//System.out.println(Panel4T5CounterMaker.backdetails[i]);
//}
//System.out.println();
////--------------------

//Panel4T5CounterMaker.bc
    for (int i = 0; i < Panel4T5CounterMaker.bc.length; i++) {
      System.out.println(Panel4T5CounterMaker.bc[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.dirsa
    for (int i = 0; i < Panel4T5CounterMaker.dirsa.length; i++) {
      System.out.println(Panel4T5CounterMaker.dirsa[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.exts
    for (int i = 0; i < Panel4T5CounterMaker.exts.length; i++) {
      System.out.println(Panel4T5CounterMaker.exts[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.fc
    for (int i = 0; i < Panel4T5CounterMaker.fc.length; i++) {
      System.out.println(Panel4T5CounterMaker.fc[i]);
    }
    System.out.println();
//--------------------

////Panel4T5CounterMaker.filelines
//    for (int i = 0; i < Panel4T5CounterMaker.filelines.length; i++) {
//      System.out.println(Panel4T5CounterMaker.filelines[i]);
//    }
//    System.out.println();
////--------------------
////Panel4T5CounterMaker.files
//for(int i=0; i<Panel4T5CounterMaker.files.length;i++) {
//System.out.println(Panel4T5CounterMaker.files[i]);
//}
//System.out.println();
////--------------------
//
////Panel4T5CounterMaker.files
//for(int i=0; i<Panel4T5CounterMaker.files.length;i++) {
//System.out.println(Panel4T5CounterMaker.files[i]);
//}
//System.out.println();
////--------------------
//
////Panel4T5CounterMaker.frontdetails
//for(int i=0; i<Panel4T5CounterMaker.frontdetails.length;i++) {
//System.out.println(Panel4T5CounterMaker.frontdetails[i]);
//}
//System.out.println();
////--------------------
//Panel4T5CounterMaker.jtbc
    for (int i = 0; i < Panel4T5CounterMaker.jtbc.length; i++) {
      System.out.println(Panel4T5CounterMaker.jtbc[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.jtfc
    for (int i = 0; i < Panel4T5CounterMaker.jtfc.length; i++) {
      System.out.println(Panel4T5CounterMaker.jtfc[i]);
    }
    System.out.println();
//--------------------

////Panel4T5CounterMaker.jtfs
//for(int i=0; i<Panel4T5CounterMaker.jtfs.length;i++) {
//System.out.println(Panel4T5CounterMaker.jtfs[i]);
//}
//System.out.println();
////--------------------
//Panel4T5CounterMaker.lines
    for (int i = 0; i < Panel4T5CounterMaker.lines.length; i++) {
      System.out.println(Panel4T5CounterMaker.lines[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.lines
    for (int i = 0; i < Panel4T5CounterMaker.lines.length; i++) {
      System.out.println(Panel4T5CounterMaker.lines[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.lines
    for (int i = 0; i < Panel4T5CounterMaker.lines.length; i++) {
      System.out.println(Panel4T5CounterMaker.lines[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.lines
    for (int i = 0; i < Panel4T5CounterMaker.lines.length; i++) {
      System.out.println(Panel4T5CounterMaker.lines[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.lines
    for (int i = 0; i < Panel4T5CounterMaker.lines.length; i++) {
      System.out.println(Panel4T5CounterMaker.lines[i]);
    }
    System.out.println();
//--------------------

//Panel4T5CounterMaker.pix
    for (int i = 0; i < Panel4T5CounterMaker.pix.length; i++) {
      System.out.println(Panel4T5CounterMaker.pix[i]);
    }
    System.out.println();
//--------------------

////Panel4T5CounterMaker.replies
//for(int i=0; i<Panel4T5CounterMaker.replies.length;i++) {
//System.out.println(Panel4T5CounterMaker.replies[i]);
//}
//System.out.println();
////--------------------
//
////Panel4T5CounterMaker.txt
//for(int i=0; i<Panel4T5CounterMaker.txt.length;i++) {
//System.out.println(Panel4T5CounterMaker.txt[i]);
//}
//System.out.println();
////--------------------
//
////Panel4T5CounterMaker.txt
//for(int i=0; i<Panel4T5CounterMaker.txt.length;i++) {
//System.out.println(Panel4T5CounterMaker.txt[i]);
//}
//System.out.println();
////--------------------
  }

}
