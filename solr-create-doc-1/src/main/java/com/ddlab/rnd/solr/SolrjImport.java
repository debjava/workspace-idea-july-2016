package com.ddlab.rnd.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

import java.io.IOException;

/**
 * Created by PIKU on 7/16/2016.
 */
public class SolrjImport {

    private static String SOLR_BASE_URL = "http://localhost:8983/solr";
    private static String SOLR_CORE_NAME = "core1";
    private static String SOLR_CORE_URL = SOLR_BASE_URL + "/" + SOLR_CORE_NAME;

    public static void executeFullImport() {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("qt", "/dataimport");
        params.set("command", "full-import");
        params.set("clean", "true");//false
        try {
            QueryResponse response = solrClient.query(params);
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Imported data successfully ...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } finally {
            try {
                solrClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void executeDeltaImport() {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("qt", "/dataimport");
        params.set("command", "delta-import");
        params.set("clean", "true");//false
        try {
            QueryResponse response = solrClient.query(params);
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Delta Import Executed successfully ...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } finally {
            try {
                solrClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        executeFullImport();
        executeDeltaImport();
    }
}
