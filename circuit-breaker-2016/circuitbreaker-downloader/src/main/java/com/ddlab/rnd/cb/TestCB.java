package com.ddlab.rnd.cb;



/**
 * Created by PIKU on 8/6/2016.
 */
public class TestCB {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String contents = new FailSafeDownloader("").execute();
        System.out.println(contents);
        long time = System.currentTimeMillis() - start;
        System.out.println("Total Time :::"+time);
    }
}
