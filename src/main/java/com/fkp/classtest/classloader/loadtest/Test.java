package com.fkp.classtest.classloader.loadtest;

public class Test {
    static {
        System.out.println("The jar Test class has been loaded by " + Test.class.getClassLoader());
    }
}
