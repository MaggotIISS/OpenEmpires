/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer;/** @version 1.01 2000-04-11 @author Cay Horstmann */import java.lang.reflect.Constructor;import java.lang.reflect.Field;import java.lang.reflect.Method;import java.lang.reflect.Modifier;import javax.swing.JFrame;import javax.swing.JOptionPane;/** @author maggot */public class TestReflection {  private static SaveOutputWindow sow = new SaveOutputWindow();  private String name = null;  private String[][] args = null;  private int count = 0;  //<editor-fold defaultstate="collapsed" desc="main">  /**   @param args package.class   */  @SuppressWarnings("CallToThreadDumpStack")  public static void main(String[] args) {    // read class name from command line args or user input    getSow().setBounds(200, 0, 420, 500);    getSow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    if (!sow.isVisible()) {      getSow().setVisible(true);    }    //sow.clear();    String name;    int count = 0;    if (args.length > 0) {      name = args[count];      count += 1;    } else {      name = JOptionPane.showInputDialog("Class name (e.g. java.util.Date): ");    }    try {      // print class name and superclass name (if != Object)      Class cl = Class.forName(name);      Class supercl = cl.getSuperclass();      getSow().append("\n\nclass " + name);      if (supercl != null && supercl != Object.class) {        getSow().append(" extends " + supercl.getName());      }      getSow().append("\n{\n");      getSow().append("\t//Constructors\n");      printConstructors(cl);      //sow.append("\n");      getSow().append("\t//Methods\n");      printMethods(cl);      //sow.append();      getSow().append("\t//Fields\n");      printFields(cl);      getSow().append("}");      //sow.append("\n");      //printVariables(cl);    } catch (ClassNotFoundException e) {      e.printStackTrace();    }    //System.exit(0);  }  //</editor-fold>  /**   TestReflection   */  public TestReflection() {    super();    if (!sow.isVisible()) {      getSow().setVisible(true);    }  }  /**   @param args String array of arguments   */  public TestReflection(String[] args) {    this();    getSow().setBounds(200, 0, 420, 500);    getSow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    count = 0;    if (args.length > 0) {      name = args[count];      count += 1;    } else {      name = JOptionPane.showInputDialog("Class name (e.g. java.util.Date): ");    }    try {      // print class name and superclass name (if != Object)      Class cl = Class.forName(name);      Class supercl = cl.getSuperclass();      getSow().append("\n\nclass " + name);      if (supercl != null && supercl != Object.class) {        getSow().append(" extends " + supercl.getName());      }      getSow().append("\n{\n");      getSow().append("\t//Constructors\n");      printConstructors(cl);      //sow.append("\n");      getSow().append("\t//Methods\n");      printMethods(cl);      //sow.append();      getSow().append("\t//Fields\n");      printFields(cl);      getSow().append("}");      //sow.append("\n");      //printVariables(cl);    } catch (ClassNotFoundException e) {    }    //System.exit(0);  }  /**   @return name of class   */  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }  /**   Prints all constructors of a class   @param cl a class   */  public static void printConstructors(Class cl) {    Constructor[] constructors = cl.getDeclaredConstructors();    for (int i = 0; i < constructors.length; i++) {      Constructor c = constructors[i];      String name = c.getName();      getSow().append("   " + Modifier.toString(c.getModifiers()));      getSow().append(" " + name + "(");      // print parameter types      Class[] paramTypes = c.getParameterTypes();      for (int j = 0; j < paramTypes.length; j++) {        if (j > 0) {          getSow().append(", ");        }        getSow().append(paramTypes[j].getName());      }      getSow().append(");\n");    }  }  /**   Prints all methods of a class   @param cl a class   */  public static void printMethods(Class cl) {    Method[] methods = cl.getDeclaredMethods();    for (int i = 0; i < methods.length; i++) {      Method m = methods[i];      Class retType = m.getReturnType();      String name = m.getName();      // print modifiers, return type and method name      getSow().append("   " + Modifier.toString(m.getModifiers()));      getSow().append(" " + retType.getName() + " " + name        + "(");      // print parameter types      Class[] paramTypes = m.getParameterTypes();      for (int j = 0; j < paramTypes.length; j++) {        if (j > 0) {          getSow().append(", ");        }        getSow().append(paramTypes[j].getName());      }      getSow().append(");\n");    }  }  /**   Prints all fields of a class   @param cl a class   */  public static void printFields(Class cl) {    Field[] fields = cl.getDeclaredFields();    for (int i = 0; i < fields.length; i++) {      Field f = fields[i];      Class type = f.getType();      String name = f.getName();      getSow().append("   " + Modifier.toString(f.getModifiers()));      getSow().append(" " + type.getName() + " " + name        + ";\n");    }  }  /**   @return the sow   */  public static SaveOutputWindow getSow() {    return sow;  }  /**   @param aSow the sow to set   */  public static void setSow(SaveOutputWindow aSow) {    sow = aSow;  }  /**   @param title title to setTitle   */  public static void setTitle(String title) {    getSow().setTitle(title);  }}