package com.ddlab.rnd.cb;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by PIKU on 8/6/2016.
 */
public class HttpDownloader {

    public String download(String url, String contentType) {
        System.out.println("------------11111111111111");
        return getContents(url, contentType);


//        String urlPath = "https://developer.aptimus.com/api/validation-service/1/apti/status";
//        String response = getContents(urlPath, "application/xml");
//        System.out.println(response);
    }

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
}
