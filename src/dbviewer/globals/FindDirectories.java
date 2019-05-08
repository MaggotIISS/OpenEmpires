/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;/** @version 1.00 05 Sep 1997 @author Gary Cornell */import java.io.File;import java.util.ArrayList;/** <p> @author maggot.iiss */public class FindDirectories {  static ArrayList mylist = new ArrayList();  /**   <p>   @param args strings to start   */  @SuppressWarnings("AssignmentToMethodParameter")  public static void main(String[] args) {    if (args.length == 0) {      args = new String[]{dbviewer.globals.GlobalVariables.CB};    }    ArrayList al = listDirs(args[0]);    for (int i = 0; i < al.size(); i++) {      //System.out.print(i + " = " + al.get(i).toString());    }  }  /**   <p>   @param arg Folder to search   @return string array of directories   */  @SuppressWarnings({"AssignmentToMethodParameter", "unchecked"})  public static ArrayList listDirs(String arg) {    File pathName = new File(arg);    String[] tmp = pathName.list();    String[] fileNames = new String[tmp.length + 1];    fileNames[0] = arg;    if (tmp.length > 0) {      for (int i = 1; i < (tmp.length + 1); i++) {        fileNames[i] = tmp[i - 1];      }      for (int i = 0; i < fileNames.length; i++) {        File f = new File(pathName.getPath(), fileNames[i]);        if (f.isDirectory()) {          mylist.add(f.toString());          listDirs(f.getPath());        }      }    }    ArrayList all = new ArrayList();    all.add(arg);    for (int i = 0; i < mylist.size(); i++) {      all.add(mylist.get(i));    }    return all;  }  /**   <p>   @return name of class   */  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }}