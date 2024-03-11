package com.fkp.classtest.classloader.loadtest;

import java.io.IOException;

//如何使用Java代码主动加载一个类
    //方法1：使用Class.forName方法，使用当前类的类加载器加载指定类
    //方法2：获取到类加载器，通过类加载器的loadClass方法加载指定类
public class LoadTest {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        //方法1：使用LoadTest类的类加载器去加载Test类，也就是AppClassLoader
        Class<?> testClass = Class.forName("com.fkp.classtest.classloader.loadtest.Test");

//        //方法2：获取LoadTest类的类加载器，通过类加载器的loadClass方法加载Test类，也就是AppClassLoader
//        ClassLoader classLoader = LoadTest.class.getClassLoader();
//        Class<?> testClass = classLoader.loadClass("com.fkp.classtest.classloader.loadtest.Test");
//        testClass.newInstance();

        //方法2：获取DESCipher类的类加载器，通过类加载器的loadClass方法加载Test类，也就是ExtClassLoader
        //但是Test类不存在与ExtClassLoader加载的目录下，所以会抛出ClassNotFoundException，
        //如果需要正常加载需要将包含Test类的jar包指定jvm参数-Djava.ext.dirs=
//        ClassLoader classLoader2 = DESCipher.class.getClassLoader();
//        Class<?> testClass = classLoader2.loadClass("com.fkp.classtest.classloader.loadtest.Test");
    }
}
