package com.demo.lambda;

import java.util.Arrays;

/**
 * Created by chenxi.chen on 16/7/25.
 */
public class LambdaTest {
    public static void main(String[] args) {
        testAnonymousClass();
    }
    public static void testAnonymousClass() {
        Integer[] nums = {2, 5, 1, 6};
        Arrays.sort(nums, (o1, o2) -> {
            if(o1 < o2)
                return -1;
            return 0;
        });
        for (Integer n : nums) {
            System.out.println(n);
        }
    }
}
