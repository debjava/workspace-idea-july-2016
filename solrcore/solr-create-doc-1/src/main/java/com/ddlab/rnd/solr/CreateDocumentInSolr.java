//package com.ddlab.rnd.solr;
//
//import org.apache.solr.client.solrj.SolrClient;
//import org.apache.solr.client.solrj.SolrServerException;
//import org.apache.solr.client.solrj.impl.HttpSolrClient;
//import org.apache.solr.client.solrj.response.UpdateResponse;
//import org.apache.solr.common.SolrInputDocument;
//import org.apache.solr.common.util.NamedList;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * Created by PIKU on 7/9/2016.
// * https://wiki.apache.org/solr/Solrj#Reading_Data_from_Solr
// */
//public class CreateDocumentInSolr {
//
//    private static String SOLR_BASE_URL = "http://localhost:8983/solr";
//    private static String SOLR_CORE_NAME = "test_solr_core";
//    private static String SOLR_CORE_URL = SOLR_BASE_URL + "/" + SOLR_CORE_NAME;
//
////    private static void storeInSolr(SolrClient solrClient) {
////        try {
////            UpdateResponse response = solrClient.add(solrInputDoc);
////            int status = response.getStatus();
////            System.out.println("Update Status : " + status);
////            UpdateResponse response = solrClient.commit();
////            NamedList<Object> namedList = response.getResponse();
////            for (int i = 0; i < namedList.size(); i++) {
////                System.out.println(namedList.getName(i) + "---" + namedList.get(namedList.getName(i)));
////            }
////        } catch (SolrServerException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        } finally {
////            try {
////                solrClient.close();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//    private static void push2SOLR(String solrURL, SolrInputDocument solrInputDoc) {
//        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
//        try {
//            UpdateResponse response = solrClient.add(solrInputDoc);
//            int status = response.getStatus();
//            System.out.println("Update Status : " + status);
//            NamedList<Object> responseNamedList = response.getResponse();
//            for (int i = 0; i < responseNamedList.size(); i++) {
//                System.out.println(responseNamedList.getName(i) +
//                        "---" + responseNamedList.get(responseNamedList.getName(i)));
//            }
//            System.out.println("Before committing the file...");
//            response = solrClient.commit();
//            NamedList<Object> namedList = response.getResponse();
//            for (int i = 0; i < namedList.size(); i++) {
//                System.out.println(namedList.getName(i) + "---" + namedList.get(namedList.getName(i)));
//            }
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
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
//    private static void push2SOLR(String solrURL, Collection<SolrInputDocument> solrDocs) {
//        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
//        try {
//            UpdateResponse response = solrClient.add(solrDocs);
//            int status = response.getStatus();
//            System.out.println("Update Status : " + status);
//            response = solrClient.commit();
//            NamedList<Object> namedList = response.getResponse();
//            for (int i = 0; i < namedList.size(); i++) {
//                System.out.println(namedList.getName(i) + "---" + namedList.get(namedList.getName(i)));
//            }
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
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
//    public static void createADocument(String solrURL) {
//        SolrInputDocument solrInputDoc = new SolrInputDocument();
//        solrInputDoc.addField("id", "1");
//        solrInputDoc.addField("title_s", "Title_113");
//        solrInputDoc.addField("author_s", "Author_113");
//        push2SOLR(SOLR_CORE_URL, solrInputDoc);
//    }
//
//    public static void createSOLRDocuments(String solrURL) {
//        Collection<SolrInputDocument> solrDocs = new ArrayList<SolrInputDocument>();
//
//        for (int i = 300; i < 305; i++) {
//            SolrInputDocument solrInputDoc = new SolrInputDocument();
//            solrInputDoc.addField("id", String.valueOf(i + 1));
//            solrInputDoc.addField("title_s", "Title_" + (i + 1));
//            solrInputDoc.addField("author_s", "Author_" + (i + 1));
//
//            solrDocs.add(solrInputDoc);
//        }
//        push2SOLR(SOLR_CORE_URL, solrDocs);
//    }
//
//    public static void deleteById(String solrURL, String id) {
//        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
//        try {
//            solrClient.deleteById(id);
//            solrClient.commit();
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
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
//    public static void deleteByQuery(String solrURL, String queryString) {
//        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
//        try {
//            solrClient.deleteByQuery(queryString);
//            solrClient.commit();
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
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
//    public static void deleteAll(String SOLR_CORE_URL) {
//        deleteByQuery(SOLR_CORE_URL, "*:*");
//    }
//
//    public static void main(String[] args) {
//
//        createADocument(SOLR_CORE_URL);
////        createSOLRDocuments(SOLR_CORE_URL);
//
////        deleteById(SOLR_CORE_URL,"6");
//
////        deleteByQuery(SOLR_CORE_URL,"title_s:"+"\""+"New Elements"+"\"");
//
////        deleteAll(SOLR_CORE_URL);
//    }
//
//
//}
