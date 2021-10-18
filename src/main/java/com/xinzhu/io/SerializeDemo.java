package com.xinzhu.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Create By GuoFZ on 2021/10/18
 */
public class SerializeDemo {
    public static void main(String[] args) throws IOException {
        // 创建一个实体类对象
        Employee employee1 = new Employee();
        employee1.setName("zhangSan");
        employee1.setAddress("上海市浦东新区");
        employee1.setAge(23);
        Employee employee2 = new Employee();
        employee2.setName("liSi");
        employee2.setAddress("海南省三亚市");
        employee2.setAge(24);
        Employee employee3 = new Employee();
        employee3.setName("Jack");
        employee3.setAddress("新疆维吾尔自治区");
        employee3.setAge(25);

        // 创建集合
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        employeeOutput(employees);
        employeeInput();
    }

    /**
     * 序列化
     * @param employees
     * @throws IOException
     */
    private static void employeeOutput(ArrayList<Employee> employees) throws IOException {
        FileOutputStream fileOutput = null;
        ObjectOutput objectOutput = null;

        try {
            fileOutput = new FileOutputStream("ccc.txt");
            objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectOutput.close();
            fileOutput.close();
        }
    }

    /**
     * fan序列化
     * @param
     * @throws IOException
     */
    private static void employeeInput() throws IOException {
        FileInputStream fileInput = null;
        ObjectInputStream objectInput = null;

        try {
            fileInput = new FileInputStream("ccc.txt");
            objectInput = new ObjectInputStream(fileInput);
            ArrayList readObject = (ArrayList) objectInput.readObject();
            for (int i = 0; i < readObject.size(); i++) {
                Employee employee = (Employee) readObject.get(i);
                employee.addressCheck();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            objectInput.close();
            fileInput.close();
        }
    }

}
