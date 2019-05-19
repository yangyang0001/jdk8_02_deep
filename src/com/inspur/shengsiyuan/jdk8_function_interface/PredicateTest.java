package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.Predicate;

/**
 * Created by Administrator on 2019/4/11.
 */
public class PredicateTest {

    public static void main(String[] args){
        PredicateTest test = new PredicateTest();
        test.testPredicate(10, (value) -> value - 5 > 0);
    }

    public void testPredicate(Integer input, Predicate<Integer> predicate){
        System.out.println(predicate.test(input));
    }
}
