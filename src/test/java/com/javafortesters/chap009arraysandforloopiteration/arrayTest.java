package com.javafortesters.chap009arraysandforloopiteration;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void copyRange() {
        String[] midDays = Arrays.copyOfRange(workdays, 2, 10);
        assertEquals(8, midDays.length);
        assertEquals(midDays[2], "Friday");
        assertEquals(null, midDays[3]);
    }

    @Test
    public void testFill() {
        int[] minusOne = new int[30];
        Arrays.fill(minusOne, -1);
        assertEquals(-1, minusOne[0]);
        Arrays.fill(minusOne, -2);
        assertEquals(-2, minusOne[0]);
        Arrays.fill(minusOne, 1, 5, -1);
        for (int i = 0; i < 5; i++) {
            assertEquals(true, minusOne[i] <= minusOne[i+1]);
            System.out.println(minusOne[i]);
        }
    }

    @Test
    public void testSort() {
        int[] num = {0,2,4,3,6,5,1};
        Arrays.sort(num);
        assertEquals(0, num[0]);
        assertEquals(1, num[1]);
        assertEquals(2, num[2]);
        assertEquals(3, num[3]);
        assertEquals(4, num[4]);
        assertEquals(5, num[5]);
    }

    @Test
    public void testStringSort() {
        String[] strings = {"A", "a", "b", "D", "d", "c"};
        Arrays.sort(strings);

        assertEquals("a", strings[0]);
    }

    @Test
    public void testStringsSort() {
        Arrays.sort(workdays);
        assertEquals("Friday", workdays[0]);
        assertEquals("Wednesday", workdays[4]);

        String[] assortedDays = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(assortedDays);

    }

    public void print2DIntArray(int [][]multi){
        for(int[] outer : multi){
            if(outer==null){
                System.out.print("null");
            }else{
                for(int inner : outer){
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void run2D(){
        int [][] twoDArr = {
                {},
                {1, 2, 3},
                {0, 1},
                {5},
                {},
        };
        print2DIntArray(twoDArr);
    }

    @Test
    public void createTriangle() {
        int [][] triangle = new int[16][];
        for (int row = 0; row < 16; row++) {
            triangle[row] = new int[row+1];
            for (int i = 0; i < (row+1); i++) {
                triangle[row][i] = i;
            }
        }
        print2DIntArray(triangle);
    }

    @Test
    public void testSimpleCollection() {
        List<String> number0123 = new ArrayList<String>();

        number0123.add("zero");
        number0123.add("one");
        number0123.add("two");
        number0123.add("three");

        for (String number : number0123) {
            System.out.println(number);
        }

        assertEquals("zero", number0123.get(0));
        assertEquals("three", number0123.get(3));
    }


}
