package com.javafortesters.chap004testswithotherclasses.examples;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class IntegerExamplesTest {
    @Test
    public void integerExploration(){
//        Integer four = 4;
//        assertEquals("intValue returns int 4", 4, four.intValue());
//
//        Integer five = Integer.valueOf("5");
//        assertEquals("value should be a string 5", 5, five.intValue());
//
//        Integer eleven = 11;
//        assertEquals("assert if it is a hex string", "15", Integer.toHexString(21));

        int firstFour = 4;
        int secondFour = 4;
        assertEquals(firstFour, secondFour);
        assertTrue(firstFour == secondFour);



    }
}
