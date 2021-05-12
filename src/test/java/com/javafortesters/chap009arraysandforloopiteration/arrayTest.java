package com.javafortesters.chap009arraysandforloopiteration;

import org.junit.Test;
import java.util.Arrays;
import com.javafortesters.domainentities.User;

import static org.junit.Assert.assertEquals;

public class arrayTest {
    String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    @Test
    public void testWorkdays() {

        String days = "";

        for(String workday : workdays) {
            days = days + "|" + workday;
        }

        assertEquals("|Monday|Tuesday|Wednesday|Thursday|Friday|BLEH",days);
    }

    @Test
    public void testForLoop() {
        int i = 0;


        String days = "";

        for (; i<5; i++) {
            days = days + "|" + workdays[i];
        }
        assertEquals("the string doesn't match", "|Monday|Tuesday|Wednesday|Thursday|Fridaybam", days );
    }

    @Test
    public void outputWithForLoop() {
        int dayIndex = 0;
        String days = "";
        for (String workday : workdays) {
            days = days + "|" + workday;
            System.out.println("found " + workday + " on position " + dayIndex);
            dayIndex++;
            if(dayIndex > 4) break;
        }
    }

    @Test
    public void testHundredUser() {
        User[] users = new User[100];
        for(int numberOfUser = 0; numberOfUser < 100; numberOfUser++) {
            int userId = numberOfUser + 1;
            users[numberOfUser] = new User("user" + userId, "password" + userId);
        }

        //check creation
        for (User aUser : users) {
            System.out.println(aUser.getUsername() + ", " + aUser.getPassword());
        }

        assertEquals(users.length, 100);
    }

    @Test
    public void copyAndResizeArray() {
        String[] weekDays;
        weekDays = Arrays.copyOf(workdays, 7);
        assertEquals(null, weekDays[5]);
        assertEquals(null, weekDays[6]);
    }
}
