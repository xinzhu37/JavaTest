package com.xinzhu.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/10/14
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        // 从aaa文件中读取数据到bbb文件中
        // 创建两个流
        FileReader fileReader = new FileReader("aaa.txt");
        FileWriter fileWriter = new FileWriter("bbb.txt",true);

        // 循环写入文件数据
        int read = 0;
        while ((read = fileReader.read()) != -1){
            fileWriter.write(read);
            fileWriter.flush();
        }
        fileWriter.close();
        fileReader.close();
    }
}
