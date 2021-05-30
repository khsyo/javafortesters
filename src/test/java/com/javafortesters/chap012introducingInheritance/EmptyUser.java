package com.javafortesters.chap012introducingInheritance;

import com.javafortesters.domainentities.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EmptyUser extends User {
    @Test
    public void emptyUserExampleTest() {
        EmptyUser enu = new EmptyUser();
        assertEquals("username", enu.getUsername());
        assertEquals("jamesssss", enu.getPassword());
    }
}
