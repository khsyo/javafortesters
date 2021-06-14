package com.javafortesters.chap016datesAndTimes;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class datesAndTimes {

    @Test
    public void printTime(){
        long startTime = System.currentTimeMillis();
        for(int x = 0; x < 10; x++){
            System.out.println("Current time " + System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time " + (endTime - startTime));
    }

    // more accurate time measurement for activity runs really fast
    @Test
    public void useNanoTime(){
        long startTime = System.nanoTime();
        for(int x = 0; x < 10; x++){
            System.out.println("Current time " + System.currentTimeMillis());
        }

        long endTime = System.nanoTime();
        System.out.println("Total time " + (endTime - startTime));
    }

    @Test
    public void createAUniqueNameWithNoNumbers(){
        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println(initialUserID);

        String userID = initialUserID;

        for(int x = 0; x < 10; x++){
            String charReplacement = "" + ((char)('A'+x));

            String intToReplace = String.valueOf(x);
            System.out.println(intToReplace);
            userID = userID.replace(intToReplace, charReplacement);
            System.out.println(userID);
        }
        assertThat(userID.contains("0"), is(false));
        assertThat(userID.contains("1"), is(false));
        assertThat(userID.contains("2"), is(false));
        assertThat(userID.contains("3"), is(false));
        assertThat(userID.contains("4"), is(false));
        assertThat(userID.contains("5"), is(false));
        assertThat(userID.contains("6"), is(false));
        assertThat(userID.contains("7"), is(false));
        assertThat(userID.contains("8"), is(false));
        assertThat(userID.contains("9"), is(false));

        assertThat(userID.length(), is(initialUserID.length()));

    }

    @Test
    public void testDateTime(){
        Date date = new Date();
        long oneWeekFromNowTime = date.getTime();
        System.out.println(date.toString());

        oneWeekFromNowTime = oneWeekFromNowTime + (1000 * 60 * 60 * 24 * 7 );
        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        System.out.println(oneWeekFromNow.toString());

        Date sameDate = new Date();
        sameDate.setTime(date.getTime());
        assertThat(date.equals(sameDate), is(true));
        assertThat(date.compareTo(sameDate), is(0));
    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();

        sdf.applyPattern("dd/MMM/yyyy");
        assertThat(sdf.format(date), is("06/Jun/2021"));

        Date newDate = sdf.parse("2013 12 15 23:39:52.123");
        System.out.println(newDate);
    }

    @Test
    public void useCalendar(){
        Calendar cal = Calendar.getInstance();

        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.setTime(cal.getTime());
        oneWeekFromNow.add(Calendar.DATE,7);

        assertThat(oneWeekFromNow.after(cal), is(true));
        assertThat(oneWeekFromNow.before(cal), is(false));
        assertThat(oneWeekFromNow.compareTo(cal), is(1));

        Calendar newCal = Calendar.getInstance();
        newCal.set(2013, Calendar.DECEMBER, 15, 23, 49, 54);
        System.out.println(newCal.toString());
        assertThat(newCal.get(Calendar.MONTH), is(newCal.DECEMBER));
        assertThat(newCal.get(Calendar.YEAR), is(2013));
        assertThat(newCal.get(Calendar.DAY_OF_MONTH), is(15));
        assertThat(newCal.get(Calendar.HOUR_OF_DAY), is(23));
        assertThat(newCal.get(Calendar.MINUTE), is(49));
        assertThat(newCal.get(Calendar.HOUR_OF_DAY), is(23));
        assertThat(newCal.get(Calendar.AM_PM), is(newCal.PM));
        assertThat(newCal.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(newCal.get(Calendar.DAY_OF_WEEK), is(Calendar.SUNDAY));
        assertThat(newCal.get(Calendar.DAY_OF_YEAR), is(349));

        newCal.setFirstDayOfWeek(Calendar.MONDAY);

        newCal.add(Calendar.DAY_OF_MONTH, 8);
        newCal.add(Calendar.YEAR, -2);
        newCal.add(Calendar.MONTH, -6);
        newCal.add(Calendar.DAY_OF_MONTH, -20);
        assertThat(newCal.get(Calendar.DAY_OF_MONTH), is(3));
        assertThat(newCal.get(Calendar.YEAR), is(2011));
        assertThat(newCal.get(Calendar.MONTH), is(Calendar.JUNE));

    }
}
