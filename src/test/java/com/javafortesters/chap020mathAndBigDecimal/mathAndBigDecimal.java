package com.javafortesters.chap020mathAndBigDecimal;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

import com.javafortesters.domainentities.DupeUserComparator;
import com.javafortesters.domainentities.User;
import com.javafortesters.domainentities.UserComparator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class mathAndBigDecimal {

    @Test
    public void testBigDecimal(){
        BigDecimal total = new BigDecimal("0.1").add(new BigDecimal("0.15"));
        assertThat(total, is(new BigDecimal("0.25")));

        try{
            double doubleLeft = 5L - 0.43 - 0.73 - 1.73;
            System.out.println("2.11 != " + doubleLeft);
            assertThat(doubleLeft, is(2.11));
            fail("Expected the assert to fail");
        } catch( java.lang.AssertionError e){}


        int intLeft = 500 - 43 - 73 - 173;
        assertThat(intLeft, is(211));

        BigDecimal bdTotal = new BigDecimal("5")
                                .subtract(new BigDecimal("0.3"))
                                .subtract(new BigDecimal("0.47"))
                                .subtract(new BigDecimal("1.73"));
        assertThat(bdTotal, is(new BigDecimal("2.50")));

        BigDecimal aBigDecimal = new BigDecimal("0");
        assertThat(aBigDecimal, is(new BigDecimal(0)));

        BigDecimal bd10 = new BigDecimal(10);
        BigDecimal bd2 = new BigDecimal(2);

        BigDecimal bdnew = (((aBigDecimal.add(bd10)).multiply(bd2)).subtract(bd10)).divide(bd2);
        assertThat(bdnew, is(new BigDecimal(5)));
    }

    @Test
    public void compareTenAndOne(){
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) < 0, is(true));
        assertThat(BigDecimal.TEN.compareTo(BigDecimal.ONE) > 0, is(true));
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) == 0, is(false));
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) != 0, is(true));
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) <= 0, is(true));
        assertThat(BigDecimal.TEN.compareTo(BigDecimal.ONE) >= 0, is(true));
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) > 0, is(false));
        assertThat(BigDecimal.ONE.compareTo(BigDecimal.TEN) >= 0, is(false));

        assertThat(Math.max(23, 24), is(24));
    }

    @Test
    public void userComparator(){
        User bob = new User("bob", "passw0rd");
        User bob2 = new User("bob", "passw0rd!");
        User dan = new User("dan", "passw0rd");
        User bobby = new User("bobby", "passw0rd");
        User steve = new User("steve", "passw0rd");
        User steva = new User("steva", "passw0rd");
        User warnock = new User("warnock", "passw0rd");

        SortedSet<User> newSet = new TreeSet<User>(new DupeUserComparator());
        newSet.add(bob);
        newSet.add(bobby);
        newSet.add(bob2);
        newSet.add(dan);
        newSet.add(steve);
        newSet.add(warnock);
        newSet.add(steva);

        assertThat(newSet.size(), is(6));

        User[] userArray = new User[newSet.size()];
        newSet.toArray(userArray);

        assertThat(userArray[0].getUsername(), is("bob"));
        assertThat(userArray[1].getUsername(), is("dan"));
        assertThat(userArray[2].getUsername(), is("bobby"));
        assertThat(userArray[3].getUsername(), is("steve"));
    }

    @Test
    public void testImplementaionOfComparable() {
        User bob = new User("bob", "afoiadfoiadio9");
        User bob2 = new User("bobb", "afoiadfoiadio9");
        User danbrown = new User("dan", "afoiadfoiadio9");

        SortedSet<User> userSet = new TreeSet<User>();
        userSet.add(bob);
        userSet.add(bob2);
        userSet.add(danbrown);

        User[] userArray = new User[userSet.size()];
        userSet.toArray(userArray);

        assertThat(userArray[1].getUsername(), is("dan"));
        assertThat("steve".compareTo("bobby"), is(17));
    }

    @Test
    public void accessValuesInAMapInKeyOrder(){
        Map<String, String> map = new TreeMap<>();
        map.put("key5", "value5");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key1", "value1");

        SortedSet<String> keys = new TreeSet(map.keySet());

        Integer stringSuffix = 1;
        for(String key : keys){
            assertThat(key, is("key" + stringSuffix));
            stringSuffix += 1;
        }

    }
}
