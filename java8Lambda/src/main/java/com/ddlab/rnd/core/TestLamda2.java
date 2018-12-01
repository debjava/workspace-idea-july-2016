package com.ddlab.rnd.core;
public class TestLamda2 {

    public static void check(Interface2 interface2, int a, int b) {
        System.out.println(interface2.sum(a, b));
    }

    public static void main(String[] args) {
        Interface2 interface2 = (a, b) -> a + b;
        check(interface2, 10, 15);

        //OLD way of writing
        interface2 = new Interface2() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        check(interface2, 20, 25);
    }
}
