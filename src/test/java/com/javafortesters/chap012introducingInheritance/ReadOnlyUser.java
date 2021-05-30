package com.javafortesters.chap012introducingInheritance;

import com.javafortesters.domainentities.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ReadOnlyUser extends User {
//    public ReadOnlyUser(){
//        this("username", "jamessss");
//    }
//
//    public ReadOnlyUser(String username, String password){
//        super(username, password);
//    }

    @Override
    public String getPermission(){
        return "ReadOnly";
    }

    @Test
    public void checkReadOnlyUser(){
        ReadOnlyUser rod = new ReadOnlyUser();
        assertEquals("ReadOnly",rod.getPermission());
        assertEquals("username",rod.getUsername());
        assertEquals("jamesssss",rod.getPassword());
    }
}
