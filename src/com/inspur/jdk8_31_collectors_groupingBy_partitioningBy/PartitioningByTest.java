package com.inspur.jdk8_31_collectors_groupingBy_partitioningBy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/4/10.
 */
public class PartitioningByTest {

    public static void main(String[] args){

        Student student1 = new Student("zhangsan", 20, 80);
        Student student2 = new Student("lisi",     20, 85);
        Student student3 = new Student("wangwu",   22, 90);
        Student student4 = new Student("zhaoliu",  23, 88);
        Student student5 = new Student("maosan",   24, 85);
        Student student6 = new Student("gousi",    24, 95);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5, student6);

        //1.根据年龄分区,然后查询到每个分区中的score最大的student
        Map<Boolean, Student> map1 =
        studentList.stream().collect(Collectors.partitioningBy(student->student.getAge() >= 23,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                        Optional<Student>::get)));
        System.out.println(map1);

        System.out.println("------------------------------------------------------------------------------------");
        //2.根据年龄分区,然后查询对每个分区中的学生的分值求和
        Map<Boolean, Integer> map2 =
        studentList.stream().collect(Collectors.partitioningBy(student->student.getAge() >= 23,
                Collectors.summingInt(Student::getScore)));
        System.out.println(map2);



    }


}
