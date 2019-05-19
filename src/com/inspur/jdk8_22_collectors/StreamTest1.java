package com.inspur.jdk8_22_collectors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/4/9.
 */
public class StreamTest1 {

    public static void main(String[] args){

        Student student1 = new Student("zhangsan", 70);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 80);
        Student student5 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);

        //1.将集合转换成流,然后再转换成集合
        List<Student> studentList = students.stream().collect(Collectors.toList());
        //2.通过流的方式拿到集合的个数
        Long count = studentList.stream().count();
        System.out.println("count -------------------------------:" + count);
        //3.获取到集合中学生成绩最低的学生
        Student student = studentList.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).get();
        System.out.println("student -----------------------------:" + student);
        //4.获取到集合中学生成绩最大的学生
        Student minScoreStudent = studentList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore))).get();
        System.out.println("minScoreStudent ---------------------:" + minScoreStudent);
        //5.获取到学生的平均成绩
        Double avgScore = studentList.stream().collect(Collectors.averagingDouble(Student::getScore));
        System.out.println("avgScore ----------------------------:" + avgScore);
        //6.求出所有学生的成绩总和
        Integer sumScore = studentList.stream().collect(Collectors.summingInt(Student::getScore));
        System.out.println("sumScore ----------------------------:" + sumScore);
        //7.将所有的student的姓名进行拼接
        String lastJoinName = studentList.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println("lastJoinName ------------------------:" + lastJoinName);
        //8.首先根据成绩分组,再根据名字分组
        Map<Integer, Map<String, List<Student>>> map1 = studentList.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println("map1 --------------------------------:" + map1);
        //9.分区
        Map<Boolean, List<Student>> map2 = studentList.stream().collect(Collectors.partitioningBy(s-> s.getScore() > 85));
        System.out.println("map2 --------------------------------:" + map2);
        //10分区后进行结果求和
        Map<Boolean, Map<Boolean, Integer>> map3 = studentList.stream().collect(Collectors.partitioningBy(s->s.getScore()> 80, Collectors.groupingBy(s -> s.getScore() > 90, Collectors.summingInt(Student::getScore))));
        System.out.println("map3 --------------------------------:" + map3);

        DoubleSummaryStatistics doubleSummaryStatistics = studentList.stream().collect(Collectors.summarizingDouble(Student::getScore));
        System.out.println("doubleSummaryStatistics -------------:" + doubleSummaryStatistics);

        //12.先根据studentName进行分组,然后在根据每个组中的学生成绩比较,取到成绩最低的学生
        Map<String, Student> map4 =
        studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)),Optional<Student>::get)));
        System.out.println(map4);

    }
}
