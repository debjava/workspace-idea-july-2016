package com.ddlab.rnd.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Debadatta Mishra
 */
public class RegexpExample {

    public static String getServiceName(String urlString) {
        String serviceName = "";
        String urlMainPattern = "(api/.*/\\d)";
        Pattern pattern = Pattern.compile(urlMainPattern);
        Matcher matcher = pattern.matcher(urlString);
        if( matcher.find() )
            serviceName = matcher.group();
        pattern = Pattern.compile("[^api](\\b.*\\b)[^\\d]");
        matcher = pattern.matcher(serviceName);
        serviceName = matcher.find() ? matcher.group().replaceAll("/", "") : "";
        return serviceName;
    }
    public static void main(String[] args) {

        String string = "https://developer.aptimus.com/api/session-service/2/apti/status";
//        string = "https://developer.aptimus.com/api/utility/2/apti/status";

        System.out.println(getServiceName(string));


//        Pattern pattern = Pattern.compile("[a-zA-Z_0-9]*(-service)");
//        Pattern pattern = Pattern.compile("(api/.*/\\d)");
//        Matcher matcher = pattern.matcher(string);
//
//        String fq = null;
//        if (matcher.find()) {
////            System.out.println(matcher.group());
//            fq = matcher.group();
//            System.out.println("---->" + fq);
//        }
//
//        Pattern pattern1 = Pattern.compile("[^api](\\b.*\\b)[^\\d]");
//        Matcher matcher1 = pattern1.matcher(fq);
//
//        if (matcher1.find())
//            System.out.println(matcher1.group().replaceAll("/", ""));

    }
}