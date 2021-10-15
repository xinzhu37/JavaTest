package com.xinzhu.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/10/15
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        // 创建高效输入流对象
        BufferedReader br = new BufferedReader(new FileReader("bbb.txt"));
        // 循环从文本中读取每行数据
        String read;
        while ((read = br.readLine()) != null){
            System.out.println(read);
        }
        // 关闭流
        br.close();
    }
}
