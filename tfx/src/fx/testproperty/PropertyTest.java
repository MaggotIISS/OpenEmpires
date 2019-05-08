/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.testproperty;

import static dbviewer.globals.GlobalVariables.CRLF;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class PropertyTest {

  private static BooleanProperty b;
  private static DoubleProperty d;
  private static FloatProperty f;
  private static IntegerProperty i;
  private static LongProperty l;
  private static ListProperty<String> lp;
  private static MapProperty<String, String> mp;
  private static ObjectProperty<Object> o;
  private static StringProperty s;
  private static SetProperty<String> sp;

  /**
   PropertyTest
   @param ta
   */
  public PropertyTest(TextArea ta) {
    PropertyTest.b = new SimpleBooleanProperty(false);
    show(ta, "" + PropertyTest.b);
    PropertyTest.d = new SimpleDoubleProperty(3.6e-3);
    show(ta, "" + PropertyTest.d);
    PropertyTest.f = new SimpleFloatProperty(3);
    show(ta, "" + PropertyTest.f);
    PropertyTest.i = new SimpleIntegerProperty(5);
    show(ta, "" + PropertyTest.i);
    PropertyTest.l = new SimpleLongProperty(5);
    show(ta, "" + PropertyTest.l);
    PropertyTest.lp = new SimpleListProperty<>();
    show(ta, "" + PropertyTest.lp);
    PropertyTest.mp = new SimpleMapProperty<>(PropertyTest.mp, "name");
    show(ta, "" + PropertyTest.mp);
    PropertyTest.o = new SimpleObjectProperty<>("o");
    show(ta, "" + PropertyTest.o);
    PropertyTest.s = new SimpleStringProperty("£");
    show(ta, "" + PropertyTest.s);
    PropertyTest.sp = new SimpleSetProperty<>();
    show(ta, "" + PropertyTest.sp);

    showLocaleMap();
  }

  private void show(TextArea ta, String string) {
    String s = string + CRLF;
    s += "string" + " = " + string.substring(0, string.indexOf(" ")) + CRLF;
    s += "value" + " = " + string.substring(string.lastIndexOf(" "), string
      .lastIndexOf("]")) + CRLF;

    String part = string.substring(0, string.indexOf(" "));
    switch (part) {
      case "BooleanProperty": {
        break;
      }
      case "DoubleProperty": {
        break;
      }
      case "FloatProperty": {
        break;
      }
      case "IntegerProperty": {
        break;
      }
      case "LongProperty": {
        break;
      }
      case "ListProperty": {
        break;
      }
      case "MapProperty": {
        s += "  mp.get(\"key\")" + " = " + mp.get("key") + CRLF;
        s += "  mp.get(\"value\")" + " = " + mp.get("value") + CRLF;
        s += "  mp.get(\"name\")" + " = " + mp.get("name") + CRLF;
        s += "  mp.asString()" + " = " + mp.asString() + CRLF;
        s += "  mp.containsKey(\"key\")" + " = " + mp.containsKey("key")
          + CRLF;
        s += "  mp.containsKey(\"value\")" + " = " + mp.containsKey("value")
          + CRLF;
        s += "  mp.containsKey(\"name\")" + " = " + mp.containsKey("name")
          + CRLF;
        s += "  mp.toString()" + " = " + mp.toString() + CRLF;
        break;
      }
      case "ObjectProperty": {
        break;
      }
      case "SetProperty": {
        break;
      }
      case "StringProperty": {
        break;
      }
      default: {
        //<editor-fold defaultstate="collapsed" desc="JOP">
        {
          String x = "";
          x += "" + CRLF;
          x += "" + CRLF;
          JTextArea jta = new JTextArea(x, 50, 80);
          JScrollPane jsp = new JScrollPane(jta);
          JOptionPane.showMessageDialog(null, jsp);
        }
        //</editor-fold>
      }
    }
    ta.appendText(s + CRLF);
    System.out.println(s);
  }

  /**
   @return the b
   */
  public static BooleanProperty getB() {
    return b;
  }

  /**
   @param aB the b to set
   */
  public static void setB(BooleanProperty aB) {
    b = aB;
  }

  /**
   @return the l
   */
  public static LongProperty getL() {
    return l;
  }

  /**
   @param aL the l to set
   */
  public static void setL(LongProperty aL) {
    l = aL;
  }

  /**
   @return the lp
   */
  public static ListProperty<String> getLp() {
    return lp;
  }

  /**
   @param aLp the lp to set
   */
  public static void setLp(ListProperty<String> aLp) {
    lp = aLp;
  }

  /**
   @return the mp
   */
  public static MapProperty<String, String> getMp() {
    return mp;
  }

  /**
   @param aMp the mp to set
   */
  public static void setMp(MapProperty<String, String> aMp) {
    mp = aMp;
  }

  /**
   @return the o
   */
  public static ObjectProperty<Object> getO() {
    return o;
  }

  /**
   @param aO the o to set
   */
  public static void setO(ObjectProperty<Object> aO) {
    o = aO;
  }

  /**
   @return the sp
   */
  public static SetProperty<String> getSp() {
    return sp;
  }

  /**
   @param aSp the sp to set
   */
  public static void setSp(SetProperty<String> aSp) {
    sp = aSp;
  }

  /**
   @return the d
   */
  public DoubleProperty getD() {
//    System.out.println("d" + " = " + d);
    return d;
  }

  /**
   @param d the d to set
   */
  public void setD(DoubleProperty d) {
    PropertyTest.d = d;
//    System.out.println("d" + " = " + this.d);
  }

  /**
   @return the f
   */
  public FloatProperty getF() {
    return f;
  }

  /**
   @param f the f to set
   */
  public void setF(FloatProperty f) {
    PropertyTest.f = f;
  }

  /**
   @return the i
   */
  public IntegerProperty getI() {
    return i;
  }

  /**
   @param i the i to set
   */
  public void setI(IntegerProperty i) {
    PropertyTest.i = i;
  }

  /**
   @return the s
   */
  public StringProperty getS() {
    return s;
  }

  /**
   @param s the s to set
   */
  public void setS(StringProperty s) {
    PropertyTest.s = s;
  }

  private void showLocaleMap() {
    Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
    Map<String, String> languagenames = locales.collect(
      Collectors.toMap(
        ll -> ll.getDisplayLanguage(),
        ll -> ll.getDisplayLanguage(ll),
        (existingvalue, newvalue) -> existingvalue));
    String[] names = languagenames.toString().split(", ");
    for (int j = 0; j < names.length; j++) {
      System.out.println(names[j]);
    }
  }

}
