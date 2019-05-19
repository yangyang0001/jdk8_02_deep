package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.BinaryOperator;

/**
 * Created by Administrator on 2019/4/11.
 */
public class BinaryOperatorTest {

    public static void main(String[] args){
        BinaryOperatorTest test = new BinaryOperatorTest();
        test.testBinaryOperator(10, 3, (value1 , value2) -> value1 + value2);
        test.testBinaryOperator(10, 3, (value1 , value2) -> value1 - value2);
        test.testBinaryOperator(10, 3, (value1 , value2) -> value1 * value2);
        test.testBinaryOperator(10, 3, (value1 , value2) -> value1 / value2);
    }

    public void testBinaryOperator(Integer a, Integer b, BinaryOperator<Integer> binaryOperator){
        System.out.println(binaryOperator.apply(a, b));
    }
}
