package com.javafortesters.domainentities;

import com.javafortesters.domainentities.InvalidPassword;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import static  org.junit.Assert.assertEquals;

public class User implements Comparable {

    private String username;
    private String password;
    private TestAppEnv testAppEnv;


    public User() {
        this("username", "jamessssS123");
    }

    // This is a constructor, assign default value to the constructor
    // Constructor has the same naming as the class itself
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
    This is a javadoc comment
    These two are known as `accessor` or `getter` method,
    because they allow us to access or get the value of a `field`
     **/
    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) throws InvalidPassword {
        if(password.length() < 7){
            throw new InvalidPassword("Password must be > 6 chars");
        }

        String mustIncludeADigitOrUppercase = ".*[0123456789A-Z]+.*";
        if(!password.matches(mustIncludeADigitOrUppercase)) {
            throw new InvalidPassword("Password must include digit and uppercase letters");
        }

        this.password = password;
    }

    public int compareTo(Object oUser2){
        User user2 = (User)oUser2;

        if((this.username.compareTo(user2.getUsername())) == 0) {
            return 0;
        }

        int user1Length = this.getUsername().length() + this.getPassword().length();
        int user2Length = user2.getUsername().length() + user2.getPassword().length();

        int val = user1Length - user2Length;

        if(val == 0) {
            val = this.getUsername().compareTo(user2.getUsername());
        }
        return val;

    }

    public String getPermission() {
        return "Normal";
    }

}
