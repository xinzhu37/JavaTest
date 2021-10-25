package com.xinzhu.Generic;

/**
 * Create By GuoFZ on 2021/10/25
 */
public class GenericInterfaceDemo2<T> implements MyGenericInterface<T>{

    @Override
    public void eat(T s) {
        System.out.println(" 吃 " + s);
    }

    @Override
    public T speak(T s) {
        return null;
    }
}
