package com.javafortesters.chap011introducingExceptions;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class exceptions {

    @Test
    public void throwNullPointer() {
        Integer age = null;
        String ageAsString;

        try{
            ageAsString = age.toString();
        }catch(NullPointerException e){
            age = 18;
            ageAsString = age.toString();
            System.out.println("getMessage - " +
                    e.getMessage());
            System.out.println("getStacktrace - " +
                    e.getStackTrace());
            System.out.println("printStackTrace");
            e.printStackTrace();
        }

        String yourAge = "You are " + ageAsString + " years old";

        assertEquals("You are 18 years old", yourAge);
    }
}
