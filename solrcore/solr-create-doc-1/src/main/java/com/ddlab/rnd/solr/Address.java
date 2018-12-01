package com.ddlab.rnd.solr;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by PIKU on 7/9/2016.
 */
public class Address {
    @Field("streetNo")
    private String streetNo;
    @Field("city")
    private String city;
    @Field("country")
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
