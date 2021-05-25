package com.javafortesters.chap010collections;

import org.junit.Test;

import com.javafortesters.domainentities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;
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

        daysOfWeek.remove("Sunday");
        assertEquals(6, daysOfWeek.size());

        daysOfWeek.add("Sunday");

        for (Object day : daysOfWeek) {
            System.out.println(day);
        }

        assertTrue("The collection doesn't contain expected string.",daysOfWeek.contains("Sunday"));

//        Collection<String> daysOfWeek2 = new ArrayList();
//
//        daysOfWeek2.addAll(daysOfWeek);
//        assertEquals(7, daysOfWeek2.size());
//        daysOfWeek2.clear();
//        assertEquals(1, daysOfWeek2.size());
    }

    @Test
    public void testDaysOfWeek() {
        Collection<String> workdays = new <String>ArrayList();
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        Collection<String> weekenddays = new <String>ArrayList();
        weekenddays.add("Saturday");
        weekenddays.add("Sunday");

        Collection<String> daysOfWeek = new <String>ArrayList();
        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekenddays);

        assertEquals(7, daysOfWeek.size());

        daysOfWeek.removeAll(weekenddays);
        assertTrue(daysOfWeek.containsAll(workdays));

        Object[] array = daysOfWeek.toArray();
        assertEquals(5, array.length);
        assertEquals("Monday", ((String)array[0]));
    }

    @Test
    public void testToArray() {
        Collection<String> workdays = new <String>ArrayList();
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        Collection<String> weekenddays = new <String>ArrayList();
        weekenddays.add("Saturday");
        weekenddays.add("Sunday");

        Collection<String> daysOfWeek = new <String>ArrayList();
        daysOfWeek.addAll(workdays);
        daysOfWeek.addAll(weekenddays);

        String[] anotherArray = new String[daysOfWeek.size()];
        daysOfWeek.toArray(anotherArray);
        assertEquals("Monday", anotherArray[0]);
    }

    @Test
    public void createAndManipulateACollectionOfUsers(){
        Collection<User> users = new <User>ArrayList();
        assertEquals(0, users.size());
        assertTrue(users.isEmpty());

        User user1 = new User("john", "password1");
        User user2 = new User("bob", "password2");

        users.add(user1);
        users.add(user2);

        assertEquals(2, users.size());
        assertFalse(users.isEmpty());

        Collection<User> users2 = new <User>ArrayList();
        assertEquals(0, users2.size());
        assertTrue(users2.isEmpty());

        User user3 = new User("ben", "password1");
        User user4 = new User("steve", "password2");

        users2.add(user3);
        users2.add(user4);


        for(User user : users) {
            System.out.println(user.getUsername());
        }
        assertEquals(4, users.size());
        assertTrue(users.containsAll(users2));

        users2.removeAll(users);
        assertEquals(0, users2.size());
    }

    @Test
    public void createAndManipulateAListOfUsers() {
        List<User> someUsers = new ArrayList<User>();

        User user1 = new User("mcclain", "passw$rd");
        User user2 = new User("mcavoy", "angeliic");

        someUsers.add(user1);
        someUsers.add(0, user2);

        assertEquals(0, someUsers.indexOf(user2));
        someUsers.remove(0);
        assertEquals("mcclain", someUsers.get(0).getUsername());
    }

    @Test
    // Set is build on the Collection so all Collection's method are available
    // Set doesn't accept duplicates
    public void learnSet() {
        Set workdays = new HashSet();

        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");
        workdays.add("Monday");

        assertEquals(1, workdays.size());
    }

    @Test
    // Map is a collection of key value pairs
    public void learnMap() {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());

        map.put("key1", "newValue1");
        assertEquals("newValue1", map.get("key1"));

        assertEquals(null, map.get("key4"));
    }
}
