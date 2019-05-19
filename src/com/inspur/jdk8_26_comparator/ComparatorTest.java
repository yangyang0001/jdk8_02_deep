package com.inspur.jdk8_26_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * Created by Administrator on 2019/4/9.
 */
public class ComparatorTest {

    public static void main(String[] args){

        List<String> list = Arrays.asList("nihao111", "hello22", "world3", "welcome444");
        //1.按字符的先后顺序进行排序
//        Collections.sort(list);
//        System.out.println(list);
        //2.lambda表达式的方式实现按长度来比较
        Collections.sort(list, (item1, item2) -> item1.length() - item2.length());
//        System.out.println(list);
        //3.使用Comparator接口来实现按长度由短到长的排序

        /**
         * 这里注意类型的推断
         */
        Collections.sort(list, Comparator.comparingInt((ToIntFunction<String>) (s) -> s.length()).reversed());
        Collections.sort(list, Comparator.comparingInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String item) {
                return item.length();
            }
        }).reversed());
        System.out.println(list);



    }
}
