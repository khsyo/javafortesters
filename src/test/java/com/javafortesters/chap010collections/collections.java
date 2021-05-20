package com.javafortesters.chap010collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class collections {

    @Test
    public void differentLoopCollection() {
        String[] someDays = {"Tuesday", "Thursday", "Wednesday", "Monday", "Saturday", "Sunday", "Friday"};

        List<String> days = Arrays.asList(someDays);

        int forWhile;

        for(forWhile = 0; days.get(forWhile) != "Monday"; forWhile++) {

        }

        List<String> newDays = new ArrayList<>();
        newDays.addAll(days);


        assertEquals(7, newDays.size());
        assertTrue(newDays.containsAll(days));


//        assertEquals("The days object has wrong number of entities",5, days.size());
//        assertEquals("Monday is at position" + forWhile, 3, forWhile);
    }

    @Test
    public void testCollectionMethod() {
        Collection<String> daysOfWeek = new <String>ArrayList();

        daysOfWeek.add("Monday");
        daysOfWeek.add("Tuesday");
        daysOfWeek.add("Wednesday");
        daysOfWeek.add("Thursday");
        daysOfWeek.add("Friday");
        daysOfWeek.add("Saturday");
        daysOfWeek.add("Sunday");

        assertEquals(7, daysOfWeek.size());

        Collection<String> daysOfWeek2 = new ArrayList();

        daysOfWeek2.addAll(daysOfWeek);
        assertEquals(7, daysOfWeek2.size());
        daysOfWeek2.clear();
        assertEquals(1, daysOfWeek2.size());
    }
}
