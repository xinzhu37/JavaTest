package com.xinzhu.Generic;

/**
 * Create By GuoFZ on 2021/10/25
 */
public class GenericInterfaceDemo implements MyGenericInterface<String>{
    @Override
    public void eat(String s) {
        System.out.println(" 吃 " + s);
    }

    @Override
    public String speak(String s) {
        return s + "！老板，再来一碗";
    }
}
