package com.ddlab.rnd.hystrix;

import com.netflix.hystrix.Hystrix;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 10; i++) {
            String s1 = new CircuitBreakerCommand("" + i).execute();
            System.out.println(i + "----" + s1);
        }
        Hystrix.reset();
    }
}