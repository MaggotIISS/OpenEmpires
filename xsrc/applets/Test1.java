/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package applets;

import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**

 @author maggot
 */
public class Test1 extends JApplet {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger.getLogger(Test1.class.getName());

  /**

   @param args strings to start
   */
  public void main(String[] args) {
    init();
  }

  /**
   Initialization method that will be called after the applet is loaded into
   the browser.
   */
  @Override
  public void init() {
    System.out.println("init");
    JLabel lab = new JLabel("Label", SwingConstants.CENTER);
    this.add(lab);
    sub();
  }

  /**
   main startup
   */
  @Override
  public void start() {
    System.out.println("start");
    sub();
  }

  /**
   stop
   */
  @Override
  public void stop() {
    System.out.println("stop");
    sub();
  }

  /**
   destroy
   */
  @Override
  public void destroy() {
    System.out.println("destroy");
    sub();
  }

  /**
   sub
   */
  private void sub() {
    System.out.println("this" + " = " + this);
    System.out.println("this.getAppletInfo()" + " = " + this.getAppletInfo());
    System.out.println("this.getName()" + " = " + this.getName());
    System.out.println("this.getParameter(\"test1\")" + " = " + this
      .getParameter("test1"));
    System.out.println("this.paramString()" + " = " + this.paramString());
    System.out.println("this.toString()" + " = " + this.toString());
  }

}
/*
 <div>applet
 <applet code="applets/Test1.class" width="300" height="300"></applet>
 <br> APPLET <br>
 </div>
 */
