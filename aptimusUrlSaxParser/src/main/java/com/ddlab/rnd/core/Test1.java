package com.ddlab.rnd.core;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by PIKU on 8/1/2016.
 */
public class Test1 {

    public static String getContents(String url, String contentType) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader(HttpHeaders.ACCEPT, contentType);
        CloseableHttpResponse response1 = null;
        try {
            response1 = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response1.getStatusLine());
        HttpEntity entity1 = response1.getEntity();
        String actualResponse = null;
        try {
            actualResponse = EntityUtils.toString(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return actualResponse;
    }

    public static void main(String[] args) throws Exception {
        String urlPath = "https://developer.aptimus.com/api/validation-service/1/apti/status";

        String response = getContents(urlPath, "application/xml");
        System.out.println(response);


//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(urlPath);
//
////        httpGet.addHeader("Accept","application/xml");
//        httpGet.addHeader(HttpHeaders.ACCEPT,"application/xml");
//
//
//        CloseableHttpResponse response1 = httpclient.execute(httpGet);
//        System.out.println(response1.getStatusLine());
//        HttpEntity entity1 = response1.getEntity();
//
//        String ss = EntityUtils.toString(entity1);
//        System.out.println(ss);
    }
}
