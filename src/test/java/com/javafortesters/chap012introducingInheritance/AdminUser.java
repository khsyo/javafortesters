package com.javafortesters.chap012introducingInheritance;

import com.javafortesters.domainentities.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdminUser extends User {
    public AdminUser() {
        this("adminuser", "password");
    }

    public AdminUser(String username, String password) {
        super(username, password);
    }

    @Override
    public String getPermission() {
        return "Elevated";
    }

    @Test
    public void testAdminUserDefaults(){
        AdminUser admin = new AdminUser();
        assertEquals("admin", admin.getUsername());
    }
}
