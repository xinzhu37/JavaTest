package com.xinzhu.io;

import java.io.*;

/**
 * Create By GuoFZ on 2021/10/14
 */
public class CopyFileInputStreamReader {
    public static void main(String[] args) throws IOException {
        // 从aaa文件中读取数据到bbb文件中
        // 创建两个流
        InputStreamReader bufferedReader = new InputStreamReader(new FileInputStream("C:\\Users\\xinzhu\\Desktop\\低效能程序员的行为与思维.doc"),"GBK");
        OutputStreamWriter bufferedWriter = new OutputStreamWriter(new FileOutputStream("fffffff.doc"),"UTF-8");

        singleChar(bufferedReader,bufferedWriter);
//        array(fr,fw);

    }

    public static void singleChar(InputStreamReader fr, OutputStreamWriter fw) throws IOException {
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
