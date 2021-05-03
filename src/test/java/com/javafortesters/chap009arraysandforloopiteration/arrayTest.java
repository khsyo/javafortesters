package com.javafortesters.chap009arraysandforloopiteration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class arrayTest {

    @Test
    public void testWorkdays() {
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        String days = "";

        for(String workday : workdays) {
            days = days + "|" + workday;
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday",days);
    }
}
