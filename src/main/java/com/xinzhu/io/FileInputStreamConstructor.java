package com.xinzhu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamConstructor{
    public static void main(String[] args) throws IOException {
   	 	// 使用File对象创建流对象
        File file = new File("D:\\java\\IdeaProjects\\JavaTest\\aaa.txt");
        FileInputStream fos = new FileInputStream(file);
      
        // 使用文件名称创建流对象
        FileInputStream fos2 = new FileInputStream("D:\\java\\IdeaProjects\\JavaTest\\aaa.txt");

//        int read = fos2.read();
//        System.out.println((char) read);
//        read = fos2.read();
//        System.out.println((char) read);
//        read = fos2.read();
//        System.out.println((char) read);
//        // 读取到最后一个，结束
//        read = fos2.read();
//        System.out.println(read);

        int read;
//        byte[] bytes = new byte[2];
        while ((read = fos2.read()) != -1){
//            System.out.println(new String(bytes,0,read));
            System.out.println((char) read);
        }


        fos2.close();
    }
}
