package com.xinzhu.collectionss;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/11/9
 */
public class MyClassLoader extends ClassLoader{
    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class log = null;
        //获得该类文件的字节码数组
        byte[] data = getData();

        if (data != null){
            log = defineClass(name, data, 0, data.length);
        }
        return log;
    }
    /**
     * 将class文件转化为字节码数组
     * @return
     */
    private byte[] getData() {

        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }


    }
}
