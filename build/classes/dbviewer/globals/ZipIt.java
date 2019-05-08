/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;/** <p> @author maggot.iiss */import java.io.BufferedInputStream;import java.io.File;import java.io.FileInputStream;import java.io.FileOutputStream;import java.io.IOException;import java.util.zip.CRC32;import java.util.zip.ZipEntry;import java.util.zip.ZipOutputStream;/** <p> @author maggot */public class ZipIt {  /**   <p>   @param args strings to start   @throws IOException fuck up   */  public static void main(String args[]) throws IOException {    if (args.length < 2) {      System.err.println("usage: java ZipIt Zip.zip file1 file2 file3");      System.exit(-1);    }    File zipFile = new File(args[0]);    if (zipFile.exists()) {      System.err.println("Zip file already exists, please try another");      System.exit(-2);    }    FileOutputStream fos = new FileOutputStream(zipFile);    try (ZipOutputStream zos = new ZipOutputStream(fos)) {      int bytesRead;      byte[] buffer = new byte[1024];      CRC32 crc = new CRC32();      for (int i = 1, n = args.length; i < n; i++) {        String name = args[i];        File file = new File(name);        if (!file.exists()) {          System.err.println("Skipping: " + name);          continue;        }        BufferedInputStream bis = new BufferedInputStream(          new FileInputStream(file));        crc.reset();        while ((bytesRead = bis.read(buffer)) != -1) {          crc.update(buffer, 0, bytesRead);        }        bis.close();        // Reset to beginning of input stream        bis = new BufferedInputStream(          new FileInputStream(file));        ZipEntry entry = new ZipEntry(name);        entry.setMethod(ZipEntry.STORED);        entry.setCompressedSize(file.length());        entry.setSize(file.length());        entry.setCrc(crc.getValue());        zos.putNextEntry(entry);        while ((bytesRead = bis.read(buffer)) != -1) {          zos.write(buffer, 0, bytesRead);        }        bis.close();      }    }  }  /**   <p>   @return name of class   */  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }}