package com.ddlab.rnd.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "hostIp", "hostName" , "hostCanonicalName" })
public class Status {

    @JsonProperty
    private String hostIp;
    @JsonProperty
    private String hostName;
    @JsonProperty
    private String hostCanonicalName;

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostCanonicalName() {
        return hostCanonicalName;
    }

    public void setHostCanonicalName(String hostCanonicalName) {
        this.hostCanonicalName = hostCanonicalName;
    }

    @Override
    public String toString() {
        return "Status{" +
                "hostIp='" + hostIp + '\'' +
                ", hostName='" + hostName + '\'' +
                ", hostCanonicalName='" + hostCanonicalName + '\'' +
                '}';
    }
}
