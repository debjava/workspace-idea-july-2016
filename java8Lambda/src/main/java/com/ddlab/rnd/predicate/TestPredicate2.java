package com.ddlab.rnd.predicate;

import java.util.function.Function;

public class TestPredicate2 {

    //Simple Function
    public static void testFunction1() {
        Function<String, Integer> stringLength = (s) -> s.length();
        System.out.println(stringLength.apply("Hello world"));//Will print 11
    }

    //Function chaining
    public static void functionChaining() {
        Function<String, Integer> stringLength = (s) -> s.length();
        Function<Integer, Boolean> greaterThanFive = (i) -> i > 5;
        // Will print true
        System.out.println(stringLength.andThen(greaterThanFive).apply("Hello world"));
    }

    //Function chaining
    public static void functionChaining1() {
        Function<String, Integer> stringLength = (s) -> s.length();
        Function<Integer, Boolean> lowerThanTen = (i) -> i < 10;
        Function<String, Boolean> function = stringLength.andThen(lowerThanTen);
        // Will print false
        System.out.println(function.apply("Hello world"));
    }

    public static void main(String[] args) {
//        testFunction1();
//        functionChaining();
        functionChaining1();
    }

}
