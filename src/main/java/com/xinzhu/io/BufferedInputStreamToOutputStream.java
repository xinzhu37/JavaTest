package com.xinzhu.io;

import java.io.*;

public class BufferedInputStreamToOutputStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        // 记录开始时间
        long start = System.currentTimeMillis();
        try {
            // 使用文件名称创建流对象
            bis = new BufferedInputStream(new FileInputStream("D:\\IEDownload\\VMware-workstation-full-16.1.0-17198959.exe"));
            bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\xinzhu\\Desktop\\dddd3.exe",true));
            int read;
            byte[] bytes = new byte[8*1024];
            while ((read = bis.read(bytes)) != -1){
                //                System.out.println(new String(bytes,0,read));
                bos.write(bytes,0,read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:"+(end - start)+" 毫秒");
    }
}
