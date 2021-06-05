package com.javafortesters.chap014moreAboutStrings;

import com.javafortesters.domainentities.InvalidPassword;
import com.javafortesters.domainentities.User;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class moreAboutStrings {

    @Test
    public void testEscapeCharacters() {
        String string = "This is \"hello\"! ";
        System.out.println(string);

        String stringTab = "The line is far \'behind";
        System.out.println(stringTab);

        String ps1 = "This is" + " String2";
        assertThat(ps1, is("This is String2"));
        String ps2 = ps1.concat(" 10202");
        assertThat(ps2, is("This is String2 10202"));

        String inConcatConvert = "" + 1;
        assertThat(inConcatConvert, is("1"));

        assertThat(Integer.valueOf("2"), is(2));
    }

    @Test
    public void constructAString(){
        char[] cArray = {'2', '3'};
        assertThat(new String(cArray), is("23"));
        assertThat(new String(cArray, 1,1), is("3"));

        byte[] bArray = "hello there".getBytes();
        assertThat(new String(bArray), is("hello there"));
        assertThat(new String(bArray, 3, 3), is("lo "));

        byte[] b8Array = new byte[0];
        try{
            b8Array = "hello there".getBytes("UTF8");
            assertThat(new String(b8Array, 3, 3, "UTF16"), is("lo "));
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
//            System.out.println(e);
        }
    }

    @Test
    public void comparingStrings(){
        String string = "hello";
        String string2 = "HeLLO";
        assertThat("The strings are not equal",string.equalsIgnoreCase(string2), is(true));
        string2.isEmpty();
    }

    @Test
    public void useRegionMatches() {
        String string = "Hello  fella";
        String substring = "young lady";
//        assertThat(string.regionMatches(true,9, substring, 6, 2), is(true));

        assertThat(string.indexOf("l"), is(2));
        assertThat(string.indexOf("l", 4), is(9));
    }

    private List<Integer> findPositionOfAllOccurrences(String string, String substring){

        List<Integer> list = new ArrayList<>();

        if(string == null || substring == null) {
            throw new IllegalArgumentException("Cannot search using null");
        }

        if(substring.isEmpty()) {
            throw new IllegalArgumentException("Substring cannot be empty");
        }

        Integer index = 0;
        while(index < string.length()) {
            index = string.indexOf(substring, index);
            list.add(index);
            index++;
            if(string.indexOf(substring, index) == -1 ) {
                break;
            }
        }

        return list;
    }

    @Test
    public void findPosition(){
        List<Integer> results;
        results = findPositionOfAllOccurrences("Hello fella", "l");
        assertThat(results.size(), is(4));
        assertThat(results.get(0), is(2));
        assertThat(results.get(1), is(3));
        assertThat(results.get(2), is(8));
        assertThat(results.get(3), is(9));
    }

    private List<Integer> findInRevereOrder(String string, String substring){

        List<Integer> results = new ArrayList<>();

        if(string == null || substring == null) {
            throw new IllegalArgumentException("Cannot search using null");
        }

        if(substring.isEmpty()) {
            throw new IllegalArgumentException("Substring cannot be empty");
        }

        Integer lastFoundPosition = string.length();

        do{
            lastFoundPosition = string.lastIndexOf(substring, lastFoundPosition);

            if(lastFoundPosition != -1) {
                results.add(lastFoundPosition);
                lastFoundPosition--;
            }
        } while (lastFoundPosition != -1);

        return results;
        }

    @Test
    public void canFindInRevereOrder(){
        List<Integer> results = new ArrayList<Integer>();
        results = findInRevereOrder("hello fella", "l");

        assertThat(results.size(), is(4));
        assertThat(results.get(0), is(9));
        assertThat(results.get(1), is(8));
        assertThat(results.get(2), is(3));
        assertThat(results.get(3), is(2));
    }

    @Test
    public void testRegex() throws InvalidPassword {
        String mustIncludeADigit = ".*[0123456789]+.*";
        assertThat("1".matches(mustIncludeADigit), is(true));

        User aUser = new User();
        aUser.setPassword("xxxxxxxx");

    }

    @Test
    public void testStringFormat(){
        Integer value = 5;
        String template = "The value could be %s ish";
        String formatted = String.format(template, value);
        assertThat(formatted, is("The value could be 5 ish"));
    }

    @Test
    public void testStringBuilder(){
        StringBuilder builder = new StringBuilder();
        builder.append("Hello thereafdasfjkashfjdasjkfashjfasnfkjanfkjasnfdkjasnfkjasakjsdfkajsd").
                replace(7, 11, "World").
                delete(5, 7);
//        assertThat(builder.toString(), is("HelloWorld"));
        builder.trimToSize();
        assertThat(builder.capacity(), is(71));

        StringBuilder builder2 = new StringBuilder();
        builder2.insert(0, "1");
        assertThat(builder2.toString(), is("1"));
        builder2.insert(1, " 2");
        assertThat(builder2.toString(), is("1 2"));
        builder2.insert(1, " 1.5");
        assertThat(builder2.toString(), is("1 1.5 2"));
    }

    @Test
    public void testSplit(){
        String csv = "1,2,3,4,5,6,7,8,9";
        String[] results = csv.split(",");
        assertThat(results.length, is(9));
        assertThat(results[0], is("1"));
        assertThat(results[8], is("9"));
    }

    @Test
    public void useSubstrings(){
        String digits = "0123456789";

        assertThat(digits.substring(5), is("56789"));
        assertThat(digits.substring(5, 8), is("567"));
    }

}
