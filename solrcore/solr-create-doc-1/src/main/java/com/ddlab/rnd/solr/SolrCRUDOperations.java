package com.ddlab.rnd.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;

import java.io.IOException;
import java.util.*;

/**
 * Created by PIKU on 7/9/2016.
 */
public class SolrCRUDOperations {

    private static String SOLR_BASE_URL = "http://localhost:8983/solr";
    private static String SOLR_CORE_NAME = "test_solr_core";
    private static String SOLR_CORE_URL = SOLR_BASE_URL + "/" + SOLR_CORE_NAME;

    /**
     * Execute query by Id
     */
    public static void executeQuery() {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        SolrQuery query = new SolrQuery();
//        query.add("id", "5");
        query.set("q","id:5");
        try {
            QueryResponse qResponse = solrClient.query(query);
            int status = qResponse.getStatus();
            if (status == 0)
                System.out.println("Query executed successfully ...");
            System.out.println(qResponse);
//            SolrDocumentList sdList = qResponse.getResults();
//            Iterator itr = sdList.iterator();
//            while( itr.hasNext() ) {
//                SolrDocument sdoc = (SolrDocument) itr.next();
//                System.out.println(sdoc.getFieldValue("fname"));
//            }

            //OR

            List<EmpBean> empBeanList = qResponse.getBeans(EmpBean.class);
            for (EmpBean eBean : empBeanList)
                System.out.println(eBean.toString());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Query -> salary: [2000 TO *] -> greater than 2000
     * Query -> salary: [* TO 500] -> Less than 500
     */
    public static void executeQuery_1() {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        SolrQuery query = new SolrQuery();
        query.set("q","id:[2000 TO *]");
        try {
            QueryResponse qResponse = solrClient.query(query);
            int status = qResponse.getStatus();
            if (status == 0)
                System.out.println("Query executed successfully ...");
            System.out.println(qResponse);
//            SolrDocumentList sdList = qResponse.getResults();
//            Iterator itr = sdList.iterator();
//            while( itr.hasNext() ) {
//                SolrDocument sdoc = (SolrDocument) itr.next();
//                System.out.println(sdoc.getFieldValue("fname"));
//            }

            //OR

            List<EmpBean> empBeanList = qResponse.getBeans(EmpBean.class);
            for (EmpBean eBean : empBeanList)
                System.out.println(eBean.toString());
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveOrUpdatePojos(String solrURL, List<EmpBean> emps) {
        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
        try {
            solrClient.addBeans(emps);
            UpdateResponse response = solrClient.commit();
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Saved successfully ...");
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

    public static void updatePojo(String solrURL, EmpBean emp) {
        SolrClient solrClient = new HttpSolrClient.Builder(solrURL).build();
        try {
            solrClient.addBean(emp);
            UpdateResponse response = solrClient.commit();
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Updated successfully ...");
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

    public static int getSalary() {
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public static void deleteAll() {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        try {
            solrClient.deleteByQuery("*:*");
            UpdateResponse response = solrClient.commit();
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Deleted all successfully ...");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        SolrClient solrClient = new HttpSolrClient.Builder(SOLR_CORE_URL).build();
        try {
            solrClient.deleteById(String.valueOf(id));
            UpdateResponse response = solrClient.commit();
            int status = response.getStatus();
            if (status == 0)
                System.out.println("Deleted id " + id + " successfully ...");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        List<EmpBean> empList = new ArrayList<EmpBean>();
        for (int i = 0; i < 20; i++) {
            EmpBean emp = new EmpBean();
            emp.setId(String.valueOf(i));
            emp.setStreetNo("#" + i);
            emp.setCity("CT Center-" + i);
            emp.setCountry("India");
            emp.setAge(i);
            emp.setFirstName("Name-" + i);
            emp.setLastName("Surname-" + i);
            emp.setEmailIds(new String[]{"a@a.com", "b@b.com"});
            emp.setSalary(getSalary());
            empList.add(emp);
        }
        saveOrUpdatePojos(SOLR_CORE_URL, empList);
    }

    public static void update() {
        //To update Employee information
        EmpBean emp = new EmpBean();
        emp.setId(String.valueOf(3));
        emp.setStreetNo("#" + 3);
        emp.setCity("CT Center-" + 3);
        emp.setCountry("Norway");
        emp.setAge(37);
        emp.setFirstName("Sabyasachee");
        emp.setLastName("Mishra");
        emp.setEmailIds(new String[]{"saby@ge.com", "sabyasachee@motilla.com"});
        updatePojo(SOLR_CORE_URL, emp);
    }


    public static void main(String[] args) {
//        deleteAll();//To delete everything
//        deleteById(0);//To delete an Id
//        save();
//        update();
//        executeQuery();
        executeQuery_1();
    }
}
