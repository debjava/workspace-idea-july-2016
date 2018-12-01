package com.ddlab.rnd.core;
public class Thread1 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread is running");
            }
        };
        Thread th1 = new Thread(runnable);
        th1.start();
    }
}
