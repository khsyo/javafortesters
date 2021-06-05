package com.javafortesters.domainentities;

import com.javafortesters.domainentities.InvalidPassword;
import org.junit.Test;
import static  org.junit.Assert.assertEquals;

public class User {

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

    public String getPermission() {
        return "Normal";
    }
}
