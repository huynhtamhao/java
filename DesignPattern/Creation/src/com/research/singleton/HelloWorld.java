package com.research.singleton;

public class HelloWorld {
    public static void main(String[] args) {
        Runtime singletonRuntime = Runtime.getRuntime();
        singletonRuntime.gc();
        System.out.println(singletonRuntime);
        Runtime anotherRuntime = Runtime.getRuntime();
        System.out.println(anotherRuntime);
        if (singletonRuntime == anotherRuntime)
            System.out.println("Hello, World !!!");
    }
}