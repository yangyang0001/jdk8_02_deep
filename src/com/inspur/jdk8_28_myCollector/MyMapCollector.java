package com.inspur.jdk8_28_myCollector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 本程序把Set类型的流转换成Map类型
 * 本例的需求:
 * Set中的元素          ["hello", "world", "hello world"]
 * Map中的元素          {"hello"="hello", "world"="world", "hello world"="hello world"}
 */
public class MyMapCollector<T> implements Collector<T, Map<T, T>, Map<T, T>> {

    @Override
    public Supplier<Map<T, T>> supplier() {
        System.out.println("supplier invoked!");
        return HashMap<T, T>::new;
    }

    @Override
    public BiConsumer<Map<T, T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return (map, item) -> {
            map.put(item, item);
        };
    }

    @Override
    public BinaryOperator<Map<T, T>> combiner() {
        System.out.println("combiner invoked!");
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<T, T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked!");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED));
    }

    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("hello world");
        Map<String,String> map = set.stream().collect(new MyMapCollector<String>());
        System.out.println(map);
    }
}
