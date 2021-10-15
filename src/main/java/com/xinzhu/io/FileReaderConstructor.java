package com.xinzhu.io;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderConstructor{
    public static void main(String[] args) throws IOException {
        // 使用file对象创建输入流
        File file = new File("aaa.txt");
        FileReader fr = new FileReader(file);

        // 使用文件名字符串直接创建输入流
        FileReader fr2 = new FileReader("aaa.txt");

        int read;
        // 使用空参构造方法
//        while ((read = fr2.read()) != -1){
//            System.out.println("read = " + (char)read);
//        }
        // 使用
        char[] chars = {'a','我','c'};
        while ((read = fr2.read(chars,0,chars.length)) != -1){
            System.out.println("read = " + read);
        }
        fr2.close();
    }
}
