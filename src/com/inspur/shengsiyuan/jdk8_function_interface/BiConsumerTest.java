package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by Administrator on 2019/4/11.
 */
public class BiConsumerTest {

    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7));
        list.forEach(System.out::println);

        System.out.println("------------------------------------------------");
        BiConsumerTest test = new BiConsumerTest();
        test.testBiConsumer(list, 10, (theList, value) -> theList.add(value));
        list.forEach(System.out::println);
    }

    public void testBiConsumer(List<Integer> list, Integer b, BiConsumer<List<Integer>, Integer> biConsumer){
        biConsumer.accept(list, b);
    }
}
