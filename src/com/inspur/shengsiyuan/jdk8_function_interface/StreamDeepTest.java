package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.stream.Stream;

/**
 * 经验证流可以合并N个流
 */
public class StreamDeepTest {

    public static void main(String[] args){

        Stream<String> firstStream = Stream.of("1", "2", "3");
        Stream<String> secodStream = Stream.of("hello", "world", "welcome");

        //内部是Stream类型的流
        Stream<Stream<String>> streamStream = Stream.of(firstStream, secodStream);

        streamStream.flatMap(stream -> stream.map(item -> item + "YANG")).forEach(System.out::println);


    }
}
