package com.fkp.classtest.runtimedata.stack;

/**
 * @description: 测试栈内存溢出
 * @author: fengkunpeng
 * @create: 2024-03-13 23:15
 */
public class StackOverFlowTest {

    private static int count;

    //设置虚拟机参数-Xss改变最大的栈内存空间
    public static void main(String[] args) {
        try {
            run();
        }catch (StackOverflowError error){
            //当发生栈内存溢出错误，若不抛出，程序会结束运行。
            System.out.println("count: " + count);
//            throw error;
        }
    }

    private static void run(){
        count++;
        run();
    }
}
