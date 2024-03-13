package com.fkp.classtest.runtimedata.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 测试堆内存溢出
 * @author: fengkunpeng
 * @create: 2024-03-13 23:33
 */
public class HeapOutOfMemoryTest {
    public static void main(String[] args) {
        //设置虚拟机参数-Xmx：堆最大空间max，-Xms：初始堆总大小total
        int count = 0;
        List<byte[]> list = new ArrayList<>();
        while (true){
            try {
                list.add(new byte[1024 * 1024 * 1024]);
                count++;
            }catch (OutOfMemoryError error){
                //当发生堆内存溢出错误，若不抛出，则下次执行又会进入catch，无限循环。
                System.out.println(count);
                throw error;
            }
        }
    }
}
