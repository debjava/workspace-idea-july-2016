package com.ddlab.rnd.solr;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Arrays;

/**
 * Created by PIKU on 7/9/2016.
 */
public class EmpBean extends Address {
    @Field("id")
    private String id;
    @Field("fname")
    private String firstName;
    @Field("lname")
    private String lastName;
    @Field("age")
    private int age;
    @Field("emailIds")
    private String[] emailIds;
    @Field("salary")
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String[] getEmailIds() {
        return emailIds;
    }

    public void setEmailIds(String[] emailIds) {
        this.emailIds = emailIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmpBean{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", emailIds=" + Arrays.toString(emailIds) +
                ", salary=" + salary +
                '}';
    }
}
