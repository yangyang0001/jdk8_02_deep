package com.inspur.shengsiyuan.jdk8_function_interface;

import java.util.function.Supplier;

/**
 * Created by Administrator on 2019/4/11.
 */
public class SupplierTest {

    public static void main(String[] args){
        SupplierTest test = new SupplierTest();
        test.testSupplier(10, () -> {
            return String.valueOf("Hello world").toUpperCase();
        });
    }

    public void testSupplier(Object input, Supplier<String> supplier){
        System.out.println(supplier.get());
    }
}
