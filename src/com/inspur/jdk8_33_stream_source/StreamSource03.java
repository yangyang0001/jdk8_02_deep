package com.inspur.jdk8_33_stream_source;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Stream源码第3节课
 * spliterator() 方法源码的介绍
 * (前三节)本节课完成对stream的创建的一个熟悉,分析过程
 */
public class StreamSource03 {

    public void test(Consumer<Integer> consumer){
        consumer.accept(100);
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().forEach(System.out::println);


        /**
         * 解决V中提出的问题:一个lambda表达式来说是否可以赋值给Consumer,也可以赋值给IntConsumer
         */
        StreamSource03 streamSource03 = new StreamSource03();

        Consumer<Integer> consumer = (i) -> System.out.println(i);
        IntConsumer intConsumer = (i) -> System.out.println(i);

        //只能通过这种lambda表达式的方式才能进行类型转换
        streamSource03.test(intConsumer::accept);
    }

    /**
     * I.首先进入stream()方法
     *      该方法被重写的三种情况:  spliterator()不能返回三种类型的spliterator如下三种类型的spliterator
     *          cannot return a spliterator that is
     *          {@code IMMUTABLE},{@code CONCURRENT}, or <em>late-binding</em>.
     *
     * II.spliterator()方法的解释归纳:
     *
     *      a.spliterator从原始的集合中的iterator中得到,并且拥有fail-fast的特性
     *      b.查看3中的源码介绍
     *
     * III.对Spliterator<T>接口中的介绍归纳:
     *      a.Spliterator遍历元素的方式有两种:单个遍历,批量(块)遍历分别对应两个方法:
     *          1.  tryAdvance          单个遍历
     *          2. forEachRemaining    块遍历
     *      b.Spliterator中的特性值:有8个
     *          {@link #ORDERED},{@link #DISTINCT},  {@link #SORTED}, {@link #SIZED},
     *          {@link #NONNULL},{@link #IMMUTABLE}, {@link #CONCURRENT}, and {@link #SUBSIZED}
     *
     *      c.分隔迭代器分为:延迟绑定迭代器和非延迟绑定迭代器,两种迭代器绑定source(源)的时机是不同的
     *          1.延迟绑定分隔迭代器是在first traversal, first split, or first query 时绑定到数据源的
     *          2.非延迟绑定迭代器是在创建的时候绑定到source上的
     *          3.分隔迭代器在绑定之前可以随意改变源,一旦绑定就尽量避免修改源的操作,否则会抛出ConcurrentModificationException
     *      d.虽然并行对分隔迭代器的运行速度有帮助,但是分隔迭代器不是线程安全的,因此必须保证在同一时刻对分隔迭代器执行是单线程的
     *        但是分隔迭代器支持多线程的并行操作!并且spliterator比原生的iterator效率更高
     *
     *      e.特化版本的使用优于普通版本
     *
     *      f.在绑定到源和遍历完成中间,禁用对source的改变(可变源也有可能出现错误)
     *
     *------------------------------------------------------------------------------------------------------------
     * IV.public interface OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
     *    extends Spliterator<T>源码的分析解释规划:
     *
     *    在Spilterator接口中的内部接口,针对与原生类型的拆分迭代器
     * V.对该接口中的OfInt的解析,并剖析出一个问题,lambda表达式对函数式接口类型的转换代码的编写
     *
     * VI.讲到ReferencePipeline.Head<>()方法,到这里就完成了对stream()的创建了!
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

}
