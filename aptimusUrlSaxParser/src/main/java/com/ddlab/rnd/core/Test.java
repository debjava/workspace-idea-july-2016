package com.ddlab.rnd.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by PIKU on 8/1/2016.
 */
public class Test {

    public static void print(InputStream in) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();
    }

    public static String getURLContent(String p_sURL) {
        URL oURL;
        URLConnection oConnection;
        BufferedReader oReader;
        String sLine;
        StringBuilder sbResponse;
        String sResponse = null;

        try {
            oURL = new URL(p_sURL);
            oConnection = oURL.openConnection();
            oReader = new BufferedReader(new InputStreamReader(oConnection.getInputStream()));
            sbResponse = new StringBuilder();

            while ((sLine = oReader.readLine()) != null) {
                sbResponse.append(sLine);
            }

            sResponse = sbResponse.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sResponse;
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

    public static void main(String[] args) throws Exception {

        String urlPath = "https://developer.aptimus.com/api/validation-service/1/apti/status";
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        StatusHandler handler = new StatusHandler();

        String xmlContents = getContents(urlPath, "application/xml");
        InputSource inputSrc = new InputSource(new StringReader(xmlContents));
        sp.parse(inputSrc, handler);

        System.out.println(handler.getStatus());

        String result = new ObjectMapper().writeValueAsString(handler.getStatus());
        System.out.println(result);
//        Status status = handler.getStatus();
//        System.out.println(status.getHostCanonicalName());
//        System.out.println(status.getHostIp());
//        System.out.println(status.getHostName());


    }
}
