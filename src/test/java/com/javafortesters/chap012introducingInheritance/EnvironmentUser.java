package com.javafortesters.chap012introducingInheritance;


import com.javafortesters.domainentities.User;
import com.javafortesters.domainobject.TestAppEnv;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnvironmentUser extends User {

    public String getUrl() {
        return TestAppEnv.getUrl();
    }

    @Test
    public void createEnvironmentUser() {
        EnvironmentUser envuser = new EnvironmentUser();

        assertEquals("username", envuser.getUsername());
        assertEquals("http://192.123.0.3:67", envuser.getUrl());
    }
}
