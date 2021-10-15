package com.xinzhu.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/10/15
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        // 创建高效的输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("aaa.txt",true));
        bw.write(76);
        bw.newLine();
        bw.write("我敢");
        bw.newLine();
        bw.write("你不敢");
        bw.newLine();
        bw.close();
    }
}
