package com.ddlab.rnd.core;
public class TestLambda1 implements Interface1 {
    public void test() {
        System.out.println("Hello World to Lambda Expression ...");
    }

    public static void checkLambda(Interface1 interface1) {
        interface1.test();
    }

    public static void main(String[] args) {

        Interface1 interface1 = () -> {
            System.out.println("Welcome to the world of Lambda");
        };
        checkLambda(interface1);
    }
}
