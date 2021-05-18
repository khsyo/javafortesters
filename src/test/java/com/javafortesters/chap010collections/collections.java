package com.javafortesters.chap010collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class collections {

    @Test
    public void differentLoopCollection() {
        String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forWhile;

        for(forWhile = 0; days.get(forWhile) != "Monday"; forWhile++) {

        }

            assertEquals("Monday is at position" + forWhile, 3, forWhile);
    }
}
