package com.xinzhu.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/10/14
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        // 从aaa文件中读取数据到bbb文件中
        // 创建两个流
        FileReader fr = new FileReader("C:\\Users\\xinzhu\\Desktop\\低效能程序员的行为与思维.doc");
        FileWriter fw = new FileWriter("C:\\Users\\xinzhu\\Desktop\\fffffff.doc",true);

        singleChar(fr,fw);
//        array(fr,fw);

    }

    public static void singleChar(FileReader fr,FileWriter fw) throws IOException {
        // 单个字符读写
        int read;
        while ((read = fr.read()) != -1){
            fw.write(read);
            fw.flush();
        }
        fr.close();
        fw.close();
    }

    public static void array(FileReader fr,FileWriter fw) throws IOException {
        // 字符数组读写
        int read;
        char[] chars = new char[1024];
        while ((read = fr.read(chars)) != -1){
            fw.write(chars,0,read);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
