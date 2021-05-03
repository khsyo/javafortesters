package com.javafortesters.domainobject;

import org.junit.Test;

public class TestAppEnv {

    String[] userObject = {"James", "Jorge", "Jamie"};

    @Test
    public void printUser(){
        for (String user : userObject) {
            System.out.println(user);
        }

    }

    public static final String DOMAIN = "192.123.0.3";
    public static final String PORT = "67";

    public static String getUrl() {
        return "http://" + DOMAIN + ":" + PORT;
    }
}
