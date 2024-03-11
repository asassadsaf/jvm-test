package com.fkp.classtest.classloader.breaktest;

import com.sun.crypto.provider.DESCipher;
import sun.net.www.ParseUtil;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * @description: 自定义类加载器打破双亲委派机制测试
 * @author: fengkunpeng
 * @create: 2024-03-11 22:40
 */
public class BreakTest {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        //指定该类加载器加载的目录
        File file = new File("E:\\IDEAWorkspace\\jvm-test\\target\\classes");
        URL url = ParseUtil.fileToEncodedURL(file);
        //可以指定该类加载器的父类加载器，若不指定则为默认AppClassLoader(getSystemClassLoader方法)
        BreakClassLoader breakClassLoader = new BreakClassLoader(new URL[]{url}, DESCipher.class.getClassLoader());

        //使用自定义类加载器加载类
        Class<?> aClass = breakClassLoader.loadClass("com.fkp.classtest.classloader.loadtest.Test");
        System.out.println(aClass.getClassLoader());

        //验证使用自定义类加载器加载相同的类，是否成功
        BreakClassLoader breakClassLoader2 = new BreakClassLoader(new URL[]{url});
        Class<?> aClass2 = breakClassLoader2.loadClass("com.fkp.classtest.classloader.loadtest.Test");
        System.out.println(aClass == aClass2);

        //验证默认的父类加载器
        System.out.println(breakClassLoader2.getParent());
        System.out.println(breakClassLoader.getParent());
        System.out.println(ClassLoader.getSystemClassLoader());

    }
}
