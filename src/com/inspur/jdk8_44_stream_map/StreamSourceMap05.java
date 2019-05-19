package com.inspur.jdk8_44_stream_map;

import java.util.Arrays;
import java.util.List;

/**
 * Stream流的第5节课     对stream().map()的理解,与解析,forEach() 的查看与分析
 */
public class StreamSourceMap05 {

    public static void main(String[] args){
        List<String> list = Arrays.asList("hello", "world", "welcome");
        list.stream().map(item -> item + "_abc").forEach(System.out::println);

        System.out.println("-----------------");

        list.stream().reduce((value1, value2) -> value1 + " " + value2).ifPresent(System.out::println);

        System.out.println("-----------------");

        list.forEach(System.out::println);

        /**
         * 1.StatelessOp 是一个中间的流中间操作的基类是继承了 ReferencePipeline 的一个内部静态接口
         *
         * 2.所有的中间操作都是返回了一个 StatelessOp,并不会执行
         *
         *
         * 3.forEach()  的分析归纳: 所有的终止操作都有 实现了 TerminalOp
         *
         *
         *
         */
    }

}
