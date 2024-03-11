package com.fkp.classtest.classloader.hotdeploy;

import java.util.Scanner;

/**
 * @description: 热部署测试
 * @author: fengkunpeng
 * @create: 2024-03-11 23:53
 */
public class HotDeployTest {
    //注意retransform命令不能修改正在执行的方法并且不能添加方法和字段，因此需要将要修改测试的逻辑放到单独的方法中。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            if (scanner.hasNext()) {
                String s = scanner.nextLine();
                if(task(s)){
                    break;
                }
            }
        }

    }

    private static boolean task(String s){
        //通过Arthas实现热部署，将exit改为quit
        if("exit".equalsIgnoreCase(s)){
            return true;
        }else {
            System.out.println(s);
        }
        return false;
    }
}
