package com.ddlab.rnd.predicate;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void consumeString(Consumer<String> consumer, String x) {
        consumer.accept(x);
    }

    public static void main(String[] args) {
        Consumer<String> function = x -> System.out.println(x);
        Consumer<String> function2 = x -> System.out.println(x.toLowerCase());
        consumeString(function, "StringA");// prints StringA
        consumeString(function2,"StringA");// prints stringa
    }
}
