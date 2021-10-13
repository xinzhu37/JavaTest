package com.xinzhu.io;

import java.io.File;
import java.io.IOException;

/**
 * Create By GuoFZ on 2021/10/13
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
        // 1. 一个File对象代表硬盘中实际存在的一个文件或者目录。
        // 2.  File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
        // 文件路径名
        String pathname = "C:\\Users\\xinzhu\\Desktop\\低效能程序员的行为与思想.txt";
        File file = new File(pathname);
        String fileName = file.getParent();
        System.out.println("fileName = " + fileName);
        File canonicalFile = file.getParentFile();
        System.out.println("canonicalFile = " + canonicalFile);

        // 从父路径名字符串和子路径名字符串创建新的 file1实例
        String parent = "C:\\Users\\xinzhu\\Desktop";
        String child = "低效能程序员的行为与思想.txt";
        File file1 = new File(parent, child);
        System.out.println("文件绝对路径:"+file1.getAbsolutePath());
        System.out.println("文件构造路径:"+file1.getPath());
        System.out.println("文件名称:"+file1.getName());
        System.out.println("文件长度:"+file1.length()+"字节");

        // 从父路径对象实例和子路径名字符串创建新的 file2实例
        File parent2 = new File("C:\\Users\\xinzhu\\Desktop");
        String child2 = "低效能程序员的行为与思想.txt";
        File file2 = new File(parent2, child2);
        System.out.println("目录绝对路径:"+parent2.getAbsolutePath());
        System.out.println("目录构造路径:"+parent2.getPath());
        System.out.println("目录名称:"+parent2.getName());
        System.out.println("目录长度:"+parent2.length());


        File file3 = new File("D:\\java\\IdeaProjects\\JavaTest\\src\\main\\java\\com\\xinzhu\\io\\FileIO.java");
        File file5 = new File("D:\\java\\IdeaProjects\\JavaTest\\src\\main\\java\\com\\xinzhu\\io");
        System.out.println("file3.exists() = " + file3.isDirectory());
        System.out.println("file5.exists() = " + file5.isDirectory());

        File file4 = new File("aaa.java");
        System.out.println("file4.exists() = " + file4.exists());

        System.out.println("文件的创建-----------");
        File file6 = new File("aaa.txt");
        System.out.println("file6.exists() = " + file6.exists());
        System.out.println("file6.createNewFile() = " + file6.createNewFile());
        System.out.println("file6.createNewFile() = " + file6.createNewFile());
        System.out.println("file6.exists() = " + file6.exists());

        System.out.println("目录的创建-----------");
        File newDir = new File("newDir");
        System.out.println("newDir.isDirectory() = " + newDir.isDirectory());
        System.out.println("newDir.mkdir() = " + newDir.mkdir());
        System.out.println("newDir.mkdir() = " + newDir.mkdir());
        System.out.println("newDir.isDirectory() = " + newDir.isDirectory());

        System.out.println("多级目录的创建-------");
        File file7 = new File("newDir2\\newInDir\\newInDir2");
        System.out.println("file7.mkdir() = " + file7.mkdir());
        File file8 = new File("newDir2\\newInDir");
        System.out.println("file8.mkdirs() = " + file8.mkdirs());

        System.out.println("删除目录---------");
        System.out.println("file6.delete() = " + file6.delete());
        System.out.println("newDir.delete() = " + newDir.delete());
        System.out.println("file8.delete() = " + file8.delete());

    }
}
