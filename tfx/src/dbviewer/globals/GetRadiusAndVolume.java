/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;import java.text.NumberFormat;/** <p> @author Your Name Mark Ferguson maggot.iiss@sky.com */public class GetRadiusAndVolume {  private static double r, d, cv, dv, dt, m;  private static String CRLF = System.lineSeparator();  /**   <p>   @param args strings to start   */  public static void main(String[] args) {    r = 1.5;    d = r * 2;    cv = (d * d * d);//    dv = Math.cbrt(cv);    //System.out.print("d" + " = " + d+"m");    //System.out.print("cv" + " = " + cv+"m3");//    //System.out.print("dv" + " = " + dv);    showVolumes();    //System.out.print("dt" + " = " +getVolume(r)+"dt");    //System.out.print("r" + " = " +getRadius(dt)+"m");  }  // return volume in DTs given radius in metres  /**   <p>   @param radius of object   @return volume in DTs given radius in metres   */  public static double getVolume(double radius) {    d = radius * 2;    dt = (((d * d * d) * 0.5236) / 13.5);    return dt;  }  // return radius in metres given volume in DTs  /**   <p>   @param dt dTons of size to calculate   @return radius in metres given volume in DTs   */  public static double getRadius(double dt) {    cv = (dt / 0.5236) * 13.5;    d = Math.cbrt(cv);    r = d / 2;    return r;  }  private static void showVolumes() {    int num = 0;    NumberFormat nf = NumberFormat.getInstance();    double inc = 0.5;    for (double i = 1; i < 15; i += inc) {      num = (int) getVolume(i);      //System.out.print("sphere(" + i + "m)" + " = " + nf.format(num) + " dtons");    }    inc = 1;    for (double i = 15; i < 148; i += inc) {      num = (int) getVolume(i);      //System.out.print("sphere(" + i + "m)" + " = " + nf.format(num/1000) + " kdtons");    }    inc = 0.5;    for (double i = 148; i < 1907; i += inc) {      num = (int) getVolume(i);      //System.out.print("sphere(" + i + "m)" + " = " + nf.format(num/1000000) + " mdtons");    }  }}