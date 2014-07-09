package com.demo.annotation.sample;

import java.lang.reflect.Method;

/**
 * 处理注释
 * Created by chenxi.chen on 2014/06/12/下午3:43.
 * @author chenxi.chen
 */
public class TestProcessor
{
    public static void process(String clazz)
            throws ClassNotFoundException
    {
        int passed = 0;
        int failed = 0;
        //遍历obj对象的所有方法
        for (Method m : Class.forName(clazz).getMethods())
        {
            //如果包含@Testable标记注释
            if (m.isAnnotationPresent(Testable.class))
            {
                try
                {
                    //调用m方法
                    m.invoke(null);
                    //passed加1
                    passed++;
                }
                catch (Exception ex)
                {
                    System.out.printf("方法" + m + "运行失败，异常：" + ex.getCause() + "\n");
                    failed++;
                }
            }
        }
        //统计测试结果
        System.out.printf("共运行了:" + (passed + failed)+ "个方法，其中：\n" +
                "失败了:" + failed + "个，\n" +
                "成功了:" + passed + "个！\n");
    }
}
