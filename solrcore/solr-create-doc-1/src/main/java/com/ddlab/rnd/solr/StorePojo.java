//package com.ddlab.rnd.solr;
//
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.response.UpdateResponse;
//
//import java.io.IOException;
//
///**
// * Created by PIKU on 7/9/2016.
// */
//public class StorePojo {
//
//    private static String SOLR_BASE_URL = "http://localhost:8983/solr";
//    private static String SOLR_CORE_NAME = "test_solr_core";
//    private static String SOLR_CORE_URL = SOLR_BASE_URL + "/" + SOLR_CORE_NAME;
//
//    public static void saveOrUpdatePojo(String solrURL, EmpBean emp) {
//        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
//        try {
//            solrClient.addBean(emp);
//            UpdateResponse response = solrClient.commit();
//            int status = response.getStatus();
//            if( status == 0 )
//                System.out.println("Saved successfully ...");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                solrClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        EmpBean emp = new EmpBean();
//        emp.setId("1");
//        emp.setStreetNo("#16");
//        emp.setCity("CT Center, OSLO");
//        emp.setCountry("Norway");
//        emp.setAge(23);
//        emp.setFirstName("John");
//        emp.setLastName("Abraham");
//        emp.setEmailIds(new String[]{"a@a.com","b@b.com"});
//        saveOrUpdatePojo(SOLR_CORE_URL, emp);
//    }
//}
