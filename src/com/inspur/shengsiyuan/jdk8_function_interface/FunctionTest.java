package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.Function;

/**
 * Created by Administrator on 2019/4/11.
 */
public class FunctionTest {

    public static void main(String[] args){
        FunctionTest test = new FunctionTest();
        test.testFunction(5, (value) -> value + 2);
        test.testFunction(5, (value) -> value - 2);
        test.testFunction(5, (value) -> value * 2);
        test.testFunction(5, (value) -> value / 2);
    }

    public void testFunction(Integer input, Function<Integer, Integer> function){
        System.out.println(function.apply(input));
    }
}
