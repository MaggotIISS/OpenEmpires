/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer;import java.awt.event.MouseAdapter;import java.awt.event.MouseEvent;import java.io.File;import java.util.ArrayList;import javax.swing.DefaultListModel;import javax.swing.JFrame;import javax.swing.JList;import javax.swing.JPanel;import javax.swing.JScrollPane;import panels.Frame4;import panels.Panel4;/** @author maggot */public class Help {  static JList jl = null;  static DefaultListModel dlm = new DefaultListModel();  static final String path = dbviewer.globals.GlobalVariables.SRC;  static File f = null;  static final String[] fs = null;  static ArrayList ds = dbviewer.globals.FindDirectories.listDirs(path);  static ArrayList al = new ArrayList();  /**   @param args strings to start   */  @SuppressWarnings("unchecked")  public static void main(String[] args) {    int num = 0;    String[] ret;    for (int i = 0; i < ds.size(); i++) {      //System.out.print("directory" + " = " + ds.get(i).toString());      ret = dbviewer.globals.FilteredListing.getFilteredListing(ds.get(i)        .toString(), ".java");      for (int j = 0; j < ret.length; j++) {        dlm.addElement(ds.get(i).toString().replace("\\", "/") + "/" + ret[j]);        num += 1;      }      //System.out.print("files" + " = " + num);    }    //System.out.print("num" + " = " + num);    JPanel jp = new Panel4("Help");    jl = new JList(dlm);    jl.addMouseListener(new MouseAdapter() {      @Override      public void mouseClicked(MouseEvent e) {        if (e.getClickCount() > 1) {          String string = jl.getSelectedValue().toString().replace("/", "\\");          String[] splat = jl.getSelectedValue().toString().split("/");          int len = splat[splat.length - 1].length() - 5;          String part = splat[splat.length - 1].substring(0, len);          //System.out.print("Object " + part.toLowerCase() + " = new " + part + "();");          //System.out.print("//System.out.print(" + part.toLowerCase() + ".toString());");        }      }    });    JScrollPane jsp = new JScrollPane(jl);    jp.add(jsp);    JFrame jf = new Frame4(jp);    jf.setSize(300, 600);  }  /**   @return name of class   */  @Override  public String toString() {    return getClass().getName() + "[]";  }}