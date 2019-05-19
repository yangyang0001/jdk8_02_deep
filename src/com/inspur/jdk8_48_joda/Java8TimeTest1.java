package com.inspur.jdk8_48_joda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by Administrator on 2019/4/14.
 */
public class Java8TimeTest1 {

    public static void main(String[] args){
        //获取当前时间    年月日的处理
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        System.out.println("---------------------");

        //针对与年月日的处理
        LocalDate localDate1 = LocalDate.of(2019, 4, 14);
        System.out.println(localDate1);

        System.out.println("---------------------");

        MonthDay monthDay1 = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        System.out.println(monthDay1);
        MonthDay monthDay2 = MonthDay.of(localDate1.getMonth(), localDate1.getDayOfMonth());
        System.out.println(monthDay2);

        //内部的equals()已经重写了,是内容的比较
        if(monthDay1.equals(monthDay2)){
            System.out.println("equals");
        } else {
            System.out.println("no equals");
        }
        System.out.println("---------------------");

        LocalTime localTime1 = LocalTime.of(11, 22, 33);
        System.out.println(localTime1);

        System.out.println("---------------------");

        //当前日期两周后的时间
        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate3 = localDate2.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate3);

        System.out.println("---------------------");

        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime);

        System.out.println(localTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));


        //当前日期前两个月的时间
    }
}
