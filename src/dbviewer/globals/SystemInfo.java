/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;/** @version 1.10 2002-07-06 @author Cay Horstmann */import java.io.IOException;import java.util.Properties;/** This program prints out all system properties. */public class SystemInfo {  /**   <p>   @param args strings to start   */  public static void main(String args[]) {    try {      Properties sysprops = System.getProperties();      sysprops.store(System.out, "System Properties");    } catch (IOException exception) {      exception.printStackTrace();    }  }  /**   <p>   @return name of class   */  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }}