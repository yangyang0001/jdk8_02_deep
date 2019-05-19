package com.inspur.jdk8_33_stream_source;

import java.util.Arrays;
import java.util.List;

/**
 * 第4节课,对Stream的list.stream().map(item -> item).filter(item -> true).forEach(System.out::println);整体理解
 */
public class StreamSource04 {

    public static void main(String[] args){
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(item -> item).filter(item -> true).forEach(System.out::println);
    }

    /**
     * 1.ReferencePipeline 是流中源阶段和中间操作阶段的管理
     *
     * 2.ReferencePipeline.Head则是对流中源阶段的管理,Head是ReferencePipeline的内部静态类
     *
     * 3.对于ReferencePipeline和ReferencePipeline.Head二者的区别:前者包含流的源阶段和源的中间操作阶段,后者仅仅包含流的源阶段
     *
     * 4.AbstractPipeline中的构造方法,一个处理流的源的,一个追加操作的
     */

}
