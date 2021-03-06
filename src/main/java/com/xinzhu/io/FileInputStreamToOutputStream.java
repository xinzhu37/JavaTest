package com.xinzhu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamToOutputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            // 使用文件名称创建流对象
            fis = new FileInputStream("D:\\IEDownload\\VMware-workstation-full-16.1.0-17198959.exe");
            fos = new FileOutputStream("C:\\Users\\xinzhu\\Desktop\\dddd2.exe",true);
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
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:"+(end - start)+" 毫秒");
    }
}
