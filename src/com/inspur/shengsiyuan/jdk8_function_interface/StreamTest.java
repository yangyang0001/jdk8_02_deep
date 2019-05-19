package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2019/4/8.
 */
public class StreamTest {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 3, 5, 6, 7, 9);
        List<String> stringStream = Arrays.asList("hello ", "world ", "welcome ", "to ", "china");

        List<Integer> firstList = Arrays.asList(1, 3, 5 ,7);
        List<Integer> seconList = Arrays.asList(2, 4, 6 ,8);

        //1.集合通过流的方式进行打印
//        list.stream().forEach(System.out::println);
        //2.查询出集合中的所有的偶数
//        list.stream().filter(value -> value % 2 ==0).forEach(System.out::println);
        //3.集合求和
//        list.stream().reduce(Integer::sum).ifPresent(System.out::println);

        //4.将集合中的所有元素拼接成一个字符串
//        System.out.println(stringStream.stream().collect(Collectors.joining()).toString());
        //5.将集合中的所有元素转换成大写输出
//        stringStream.stream().map(String::toUpperCase).forEach(System.out::println);
        //6.将集合中的所有元素转换成大写然后拼接成字符串进行输出
//        System.out.println(stringStream.stream().map(String::toUpperCase).collect(Collectors.joining()).toString());,
        //7.将firstList和seconList中的每个元素平方然后打印出来
//        Stream<List<Integer>> stream = Stream.of(firstList, seconList);
//        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);

        //8.对集合进行sum,avg,min,max操作
//        IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::new));
//        System.out.println(summaryStatistics.getSum());
//        System.out.println(summaryStatistics.getAverage());
//        System.out.println(summaryStatistics.getMax());
//        System.out.println(summaryStatistics.getMin());

        //9.将两个集合中的交集去掉后进行并集的操作
//        //首先获取交集
//        List<Integer> theSameList = list.stream().filter(item -> seconList.contains(item)).collect(Collectors.toList());
//        //得到结果的操作
//        Stream.of(list, seconList).flatMap(theList -> theList.stream()).filter(item -> !theSameList.contains(item)).forEach(System.out::println);

        //10.找到以下集合中的所有的单词并且去重
//        List<String> stringList = Arrays.asList("hello welcome", "hello world", "hello welcome", "welcome to jdk8");
//        stringList.stream().map(item -> item.split(" "))
//                  .flatMap(stringarr -> Stream.of(stringarr)).distinct().forEach(System.out::println);

        //11.对两个集合进行全连接的显示
//        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
//        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
//        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).forEach(System.out::println);

        //12.对集合的聚合操作!List<Student>的操作,分组,分区的操作
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 80, 21);
        Student student4 = new Student("zhangsan", 80, 22);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //12.1根据student的名称进行分组,类似于Select name,count(*) from student group by name;
//        Map<String, Long> nameGroupMap = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
//        System.out.println(nameGroupMap);

        //12.2根据student的name进行分组,并且求出每个分组的score的平均值
//        Map<String,Double> nameGroupAvgMap = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
//        System.out.println(nameGroupAvgMap);

        //13.分区
//        Map<Boolean, Long> partitionMap = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 85, Collectors.counting()));
//        System.out.println(partitionMap);

        //14.对下列集合中的元素去掉相同的然后合并
        List<Integer> integerList1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> integerList2 = Arrays.asList(2, 3, 5, 8, 10);

        Stream<List<Integer>> listStream = Stream.of(integerList1, integerList2);
        listStream.flatMap(theList -> theList.stream())
                .filter(item -> !(integerList1.contains(item) && integerList2.contains(item)))
                .sorted(Integer::compareTo)
                .forEach(System.out::println);



    }


}
