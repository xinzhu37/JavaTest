package com.xinzhu.io;

import java.io.*;
import java.util.Properties;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("aaa.txt"));
        PrintWriter ps=new PrintWriter("aaaCopy.txt");
        String line;
        while((line=br.readLine())!=null) {
            ps.println(line);
            System.out.println(line);
        }
        br.close();
        ps.close();
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
    }
}
