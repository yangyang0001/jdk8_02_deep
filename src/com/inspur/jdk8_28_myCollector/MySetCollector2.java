package com.inspur.jdk8_28_myCollector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by Administrator on 2019/4/10.
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return () -> {
            System.out.println("container的创建------------------------------------------------------------");
            return new HashSet<T>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return (set, item) -> {
            //如果加上了Characteristics.CONCURRENT,一定要去掉下面的System.out.println();
            System.out.println("accumulator invoked!  " + "set -------:" + set + ",item ------:"+ item + ",threadName-----:" + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        } ;
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return (set) -> {
            Map<T, T> map = new HashMap<T, T>();
            set.forEach(item -> {
                map.put(item, item);
            });
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        /**
         * 这里点特别重要:加上IDENTITY_FINISH,finisher()中的方法就不执行了,这里不能跳过finisher()就必须去掉Characteristics.IDENTITY_FINISH
         * Characteristics.CONCURRENT:
         *      有这个参数存在:        多线程的情况下,多线程共享一个中间结果集容器(如果执行迭代操作就有可能发生ConcurrentModificationException)
         *      没有这个参数存在:      多线程的情况下,每个线程处理自己的中间结果容器(多个中间结果集容器的存在)
         */
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static void main(String[] args){

        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("hello world");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        //可以执行多次,来验证Characteristics.CONCURRENT中的使用
        for(int i =0 ;i < 1 ;i++){
            Map<String,String> map = set.parallelStream().collect(new MySetCollector2<String>());
            System.out.println(map);
            System.out.println("--------------------------------------------------------------------------------------");
        }

    }
}
