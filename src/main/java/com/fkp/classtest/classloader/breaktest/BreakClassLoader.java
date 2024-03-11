package com.fkp.classtest.classloader.breaktest;

import com.sun.crypto.provider.DESCipher;
import sun.net.www.ParseUtil;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @description: 自定义类加载器，打破双亲委派机制
 * @author: fengkunpeng
 * @create: 2024-03-11 22:24
 */
public class BreakClassLoader extends URLClassLoader {

    public BreakClassLoader(URL[] urls, ClassLoader classLoader) {
        //可以指定父类加载器，默认是AppClassLoader,getSystemClassLoader()
        super(urls, classLoader);
    }

    public BreakClassLoader(URL[] urls) {
        //可以指定父类加载器，默认是AppClassLoader,getSystemClassLoader()
        super(urls);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if(name.startsWith("java.")){
            return super.loadClass(name, resolve);
        }
        return findClass(name);
    }
}
