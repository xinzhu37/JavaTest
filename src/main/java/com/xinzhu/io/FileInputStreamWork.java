package com.xinzhu.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamWork {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileInputStream fos2 = null;

        try {
            // 使用文件名称创建流对象
            fos2 = new FileInputStream("D:\\java\\IdeaProjects\\JavaTest\\aaa.txt");
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fos2.read(bytes)) != -1){
                System.out.println(new String(bytes,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
