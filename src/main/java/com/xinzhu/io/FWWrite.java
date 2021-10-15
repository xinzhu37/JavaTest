package com.xinzhu.io;

import java.io.FileWriter;
import java.io.IOException;

public class FWWrite {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileWriter fileWriter = new FileWriter("aaa.txt");
        fileWriter.write(97);
        fileWriter.write('b');
        fileWriter.write("C");

        char[] cbuf = {'d','我','0'};
        fileWriter.write(cbuf);
        fileWriter.flush();

        //关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。
//        fileWriter.close();
    }
}
