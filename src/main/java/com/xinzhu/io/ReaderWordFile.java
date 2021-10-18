package com.xinzhu.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderWordFile {
    public static void main(String[] args) {
        //我是假设我的word文件为F:盘下的test.doc.所以先创建这个文件.
        File file = new File("C:\\Users\\xinzhu\\Desktop\\低效能程序员的行为与思维.doc");
        FileInputStream fis = null;
        Reader reader = null;
        BufferedReader br = null;
        try {
            /*创建文件输入流,这是一个字节流.然后通过Reader的封装,Reader指向的其实是InputStreamReader.InputStreamReader是字节流通向字符流的桥梁,BufferedReader再封装Reader,通过他的readLine()来读取字符*/
            fis = new FileInputStream(file);
            reader = new InputStreamReader(fis);
            br = new BufferedReader(reader);
            String strLine;
            StringBuffer sb = new StringBuffer();
            /*sb用于存读取的字符串,因为大量的append的,所以用StringBuffer,效率要大大的高于String的拼接*/
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine + "\n");
            }
            /*这个while就是这段代码的意义所在了,用readLine(),一行一行的读出doc文件中的内容*/
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                /*为了保证每个流都能关闭,最好是给每一个分别套上try catch.这个有一个关闭异常不会影响其他的关闭,我这样写显然不安全,只是为了方便*/
                fis.close();
                reader.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
} 