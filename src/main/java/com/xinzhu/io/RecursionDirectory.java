package com.xinzhu.io;

import java.io.File;

/**
 * Create By GuoFZ on 2021/10/13
 */
public class RecursionDirectory {
    public static void main(String[] args) {
        File dir = new File("D:\\java\\IdeaProjects\\JavaTest\\src\\main\\java");
        Recursion(dir);
    }

    public static void Recursion(File file){
        // 1.判断是不是目录
        if (!file.isDirectory()){
            return ;
        }

        // 2.循环遍历此文件夹下的目录或文件
        File[] files = file.listFiles();
        for (File newFile : files) {
            // 3.判断是不是目录，是目录接着递归
            if (newFile.isDirectory()){
                System.out.println("文件夹名称 = " + newFile.getName());
                Recursion(newFile);
            } else {
                // 4.是文件就直接打印名字
                System.out.println("newFile.getName() = " + newFile.getName());
            }
        }
    }
}
