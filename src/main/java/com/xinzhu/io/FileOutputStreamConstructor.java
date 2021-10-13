package com.xinzhu.io;

import java.io.*;

public class FileOutputStreamConstructor {
    public static void main(String[] args) throws IOException {
   	 	// 使用File对象来创建流对象
        File file = new File("D:\\java\\IdeaProjects\\JavaTest\\aaa.txt");
        FileOutputStream fos = new FileOutputStream(file,true);

        // 使用文件名来创建流对象
        FileOutputStream fos2 = new FileOutputStream("D:\\java\\IdeaProjects\\JavaTest\\aaa.txt",true);
        fos2.write(97);
        fos2.write(98);
        fos2.write(99);
        byte[] bytes = "我爱一China".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            fos2.write(bytes[i]);
        }
        System.out.println(bytes.length);
        fos2.write("\r\n".getBytes());
        fos2.close();

    }
}
