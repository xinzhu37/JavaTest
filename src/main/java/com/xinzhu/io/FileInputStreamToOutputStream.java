package com.xinzhu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamToOutputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 使用文件名称创建流对象
            fis = new FileInputStream("C:\\Users\\xinzhu\\Desktop\\20210909111216.jpg");
            fos = new FileOutputStream("aaa.jpg",true);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = fis.read(bytes)) != -1){
                //                System.out.println(new String(bytes,0,read));
                fos.write(bytes,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
