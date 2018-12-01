package com.ddlab.rnd.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestListComparator1 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("John Abraham");
        stringList.add("Vidya Balan");
        stringList.add("Nana Patekar");
        stringList.add("Johny Depp");
        stringList.add("Kate Winslet");
        System.out.println(stringList);
        //Sor in descending order
        Collections.sort(stringList, (String a, String b) -> b.compareTo(a));
        System.out.println(stringList);
        //Another way of writing the lambda expression
        Collections.sort(stringList, (a, b) -> b.compareTo(a));
        System.out.println(stringList);
    }
}
