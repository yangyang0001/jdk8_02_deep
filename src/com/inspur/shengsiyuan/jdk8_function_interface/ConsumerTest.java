package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.Consumer;

/**
 * Created by Administrator on 2019/4/11.
 */
public class ConsumerTest {

    public static void main(String[] args){
        ConsumerTest test = new ConsumerTest();
        String text = "yang";
        test.testConsumer(text, (value) -> System.out.println("hello " + value));
    }


    public void testConsumer(String text, Consumer<String> consumer){
        consumer.accept(text);
    }
}
