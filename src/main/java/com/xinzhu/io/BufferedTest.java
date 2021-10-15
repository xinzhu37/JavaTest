package com.xinzhu.io;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Create By GuoFZ on 2021/10/15
 */
public class BufferedTest {
    public static void main(String[] args) throws IOException {
        // 创建高效的输入流对象
        BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
        // 创建高效的输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));

        try {
            String reader;
            TreeSet<String> readerLine = new TreeSet<>();
            while ((reader = br.readLine()) != null){
                readerLine.add(reader);
            }
            Iterator<String> iterator = readerLine.iterator();
            while (iterator.hasNext()){
                bw.write(iterator.next());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
