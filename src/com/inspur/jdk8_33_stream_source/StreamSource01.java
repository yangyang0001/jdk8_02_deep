package com.inspur.jdk8_33_stream_source;

import java.util.Arrays;
import java.util.List;

/**
 * 流源码的讲解的第一节课
 * 主要看JDK中的解释
 */
public class StreamSource01 {

    public static void main(String[] args){

        Widget widget1 = new Widget("red",   20);
        Widget widget2 = new Widget("blue",  30);
        Widget widget3 = new Widget("green", 20);
        Widget widget4 = new Widget("red", 50);
        Widget widget5 = new Widget("yellow",20);
        Widget widget6 = new Widget("white", 70);

        /**
         * 1.第一个演示
         */
        List<Widget> widgetList= Arrays.asList(widget1, widget2, widget3, widget4, widget5, widget6);
        long allWeight =
        widgetList.stream()
                .filter(widget -> "red".equals(widget.getColor()))
                .mapToLong(Widget::getWeight)
                .sum();

        System.out.println(allWeight);
        /**
         * Stream<T>中的解释归纳如下:(Stream接口上的文档解释)
         * 1.上面的第一个example
         *
         * 2.流的特化形式:IntStream,LongStream, DoubleStream
         *
         * 3.流的组成部分
         *      a.唯一的源source
         *      b.0个或多个中间操作
         *      c.有一个终止操作(中间操作是惰性的,只有在终止操作的时候才进行执行)
         *
         * 4.集合和流的区别:
         *      a.集合:主要关注数据,数据的存储,数据的访问
         *      b.流:关注的是集合中元素的计算
         *
         * 5.大多数的流必须满足以下 对流操作的 行为参数(for example调用map()方法接收的参数):
         *      a.lambda表达式之间互补干扰
         *
         * 6.流的关闭操作，除非是IO,文件访问创建的流才需要关闭,集合创建的流不需要关闭,因为就是内存中数据的一种数据模式
         *
         * 7.流有串行和并行两种方式
         *
         */


    }
}
