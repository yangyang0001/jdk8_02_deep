package com.inspur.jdk8_33_stream_source;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流源码分析第2节课
 */
public class StreamSource02 {


    public static void main(String[] args){

        List<String> list = Arrays.asList("hello", "world", "hello world");

        try (Stream<String> stream = list.stream()){
            stream.onClose(() ->{
                System.out.println("aa");
                throw new NullPointerException("first Exception");
            }).onClose(() -> {
                System.out.println("bb");
                throw new ArithmeticException("second Exception");
            }).onClose(() -> {
                System.out.println("cc");
            });
        }
    }



    /**
     * BaseStream<T, S extends BaseStream<T, S>源码归纳:
     *
     * 1.BaseStream所有流实现的父接口
     *
     * 2.比较Stream和BaseStream的定义:
     *      public interface Stream<T> extends BaseStream<T, Stream<T>>
     *      public interface BaseStream<T, S extends BaseStream<T, S>>
     *
     * 3.onClose    对关闭处理器  解释:
     *      在执行close()方法的时候,执行onClose()--关闭处理器
     *      a.关闭处理器按照 添加的顺序 执行,关闭处理器之间是相互独立的
     *      b.如果任何一个关闭处理器抛出异常,后续的关闭处理器照样执行
     *      c.如果任何一个关闭处理器抛出异常,抛出来的第一个异常会抛出来,若果后面再抛出异常将会被压制
     *      d.如果关闭处理器抛出的第一个异常后,
     *        后面的关闭处理器也抛出了同一个异常the same exception (指的是同一个异常对象,不仅仅是同一种类型,是==的关系),将不会被压制
     */

}
