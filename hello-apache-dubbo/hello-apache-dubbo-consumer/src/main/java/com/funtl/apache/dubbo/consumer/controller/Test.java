package com.funtl.apache.dubbo.consumer.controller;

public class Test {
    public static void main(String[] args) {
        staticFunction();
    }
//
    static Test st = new Test();
//
    static {
        System.out.println("1");
    }
//
    {
        System.out.println("2");
    }
//
//    Test() {
//        System.out.println("3");
//
//        System.out.println("a=" + a + ",b=" + b.equals(""));
//    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static String b = "112";
}