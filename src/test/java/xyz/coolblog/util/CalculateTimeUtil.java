package xyz.coolblog.util;

/**
 * @program: mybatis-test-from-github
 * @description: 耗时计算辅助类
 * @author: Stone
 * @create: 2023-09-19 15:12
 **/
public class CalculateTimeUtil {

    public static void printCalculateTime(CalculateTimeHandler handler){
        // 记录程序开始时间
        long startTime = System.nanoTime();

        // 执行耗时操作
        handler.handler();

        // 记录程序结束时间
        long endTime = System.nanoTime();
        // 计算程序耗时（以毫秒为单位）
        long duration = (endTime - startTime) / 1000000;
        System.out.println("=====================================");
        System.out.println("程序耗时：" + duration + " 毫秒");
    }

}
