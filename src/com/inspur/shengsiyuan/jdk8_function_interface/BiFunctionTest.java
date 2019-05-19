package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.BiFunction;

/**
 * Created by Administrator on 2019/4/11.
 */
public class BiFunctionTest {

    public static void main(String[] args){
        BiFunctionTest test = new BiFunctionTest();
        test.testBiFunction(6, 2, (value1, value2) -> value1 + value2);
        test.testBiFunction(6, 2, (value1, value2) -> value1 - value2);
        test.testBiFunction(6, 2, (value1, value2) -> value1 * value2);
        test.testBiFunction(6, 2, (value1, value2) -> value1 / value2);
    }

    public void testBiFunction(Integer a, Integer b, BiFunction<Integer, Integer, Integer> biFunction){
        System.out.println(biFunction.apply(a, b));
    }
}
