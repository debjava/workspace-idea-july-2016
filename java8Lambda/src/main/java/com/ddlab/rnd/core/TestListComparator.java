package com.ddlab.rnd.core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestListComparator {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("John Abraham");
        stringList.add("Vidya Balan");
        stringList.add("Nana Patekar");
        stringList.add("Johny Depp");
        stringList.add("Kate Winslet");
        System.out.println(stringList);
        Comparator<String> comparator = (s1,s2) -> {
//            return s2.compareTo(s1);//Descending order
            return s1.compareTo(s2); //Ascending order
        };

        Collections.sort(stringList,comparator);
        System.out.println(stringList);
    }
}
