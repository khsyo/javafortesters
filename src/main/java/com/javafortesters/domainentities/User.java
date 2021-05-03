package com.javafortesters.domainentities;

public class User {

    private String username;
    private String password;


    public User(){
        this("Bobby Zamora", "james");
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

    public void setPassword(String password){
        this.password = password;
    }
}
