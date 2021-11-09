package com.xinzhu.collectionss;

/* 初始化块一
	 * 因为静态块是在类的初始化阶段完成的，
	 * 因此在创建某个类的第二个对象时，该类的静态块就不会执行了
	 * 
	 * 在单个类中，静态初始化块，初始化块，构造器
	 * 多个类的继承中初始化块、静态初始化块、构造器的执行顺序
在继承中，先后执行父类A的静态块，父类B的静态块，最后子类的静态块，然后再执行父类A的非静态块和构造器，然后是B类的非静态块和构造器，最后执行子类的非静态块和构造器
 */
public class InitDemo {
    public static void main(String[] args) {
        Initializationblock initializationblock = new Initializationblock();
        initializationblock.method();
        System.out.println("------------");
        //多打印几个对象的目的是：好看出Static静态代码块只执行一次！！！
        Initializationblock initializationblock2 = new Initializationblock(); //因为静态块是在类的初始化阶段完成的，因此在创建某个类的第二个对象时，该类的静态块就不会执行了
        initializationblock2.method();
        Initializationblock initializationblock3 = new Initializationblock();
        initializationblock3.method();


        String a = "helloWord1";

        final String b = "helloWord";
        String F = "helloWord";

        String c = b + 1;
        String e = F + 1;
        String x = "111";
        String y = x + 1;
        String z = "1111";
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println((z == y));
    }
}
