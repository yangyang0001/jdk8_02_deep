package com.inspur.jdk8_31_collectors_groupingBy_partitioningBy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/4/10.
 */
public class GroupingByTest {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 20, 80);
        Student student2 = new Student("lisi", 20, 85);
        Student student3 = new Student("wangwu", 22, 90);
        Student student4 = new Student("zhaoliu", 23, 88);
        Student student5 = new Student("maosan", 24, 85);
        Student student6 = new Student("gousi", 24, 95);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5, student6);

        //1.根据学生的成绩进行分组
        Map<Integer, List<Student>> map1 = studentList.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map1);
        System.out.println("-----------------------------------------------------------------------------------");

        //2.根据学生的年龄分组如哈偶取出每组中成绩最低的学生来
        Map<Integer, Optional<Student>> map2 =
                studentList.stream().collect(
                        Collectors.groupingBy(Student::getAge,
                                Collectors.minBy(Comparator.comparingInt(Student::getScore))));
        map2.forEach((key, student) -> {
            System.out.println("key --------:" + key + ",student -------:" + student);
        });
        System.out.println("-----------------------------------------------------------------------------------");

        //3.另外一种实现通过年龄来分组,然后获取每个分组中的成绩最低的人
//        Map<Integer, Student> map3 =
//        studentList.stream().collect(Collectors.groupingBy(Student::getAge, TreeMap::new,
//                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional<Student>::get)));
//        System.out.println(map3);

        studentList.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional<Student>::get)));

    }
}
