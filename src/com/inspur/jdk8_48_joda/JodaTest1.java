package com.inspur.jdk8_48_joda;

import org.joda.time.DateTime;

/**
 * Created by Administrator on 2019/4/14.
 */
public class JodaTest1 {

    public static void main(String[] args){
        //获取当前时间
        DateTime today = new DateTime();
        //获取明天时间
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd HH:mm:ss"));


        //获取两年前的2月份的第一天
        DateTime dateTime = new DateTime();

        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(2).dayOfMonth().withMaximumValue();
        System.out.println(dateTime1.toString("yyyy-MM-dd"));


    }

}
