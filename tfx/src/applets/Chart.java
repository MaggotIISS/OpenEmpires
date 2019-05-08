package applets;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.logging.Logger;
import javax.swing.JApplet;

/**

 @author maggot
 */
public class Chart extends JApplet {

  private static final Logger LOG = Logger.getLogger(Chart.class.getName());
  private static final long serialVersionUID = 1L;

  /**
   init
   */
  @Override
  public void init() {
    EventQueue.invokeLater(() -> {
      setBackground(Color.black);
      String v = getParameter("values");
      if (v == null) {
        return;
      }
      int n = Integer.parseInt(v);
      double[] values = new double[n];
      String[] names = new String[n];
      for (int i = 0; i < n; i++) {
        values[i] = Double.parseDouble(getParameter("value." + (i + 1)));
        names[i] = getParameter("name." + (i + 1));
      }
      add(new ChartComponent(values, names, getParameter("title"), 150000));
    });
  }
}
