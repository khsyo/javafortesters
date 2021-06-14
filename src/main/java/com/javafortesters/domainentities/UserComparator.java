package com.javafortesters.domainentities;

import java.util.Comparator;

public class UserComparator implements Comparator {
    public int compare(Object oUser1, Object oUser2) {
        User user1 = (User) oUser1;
        User user2 = (User) oUser2;

        int user1Comparator = user1.getUsername().length() + user1.getPassword().length();
        int user2Comparator = user2.getUsername().length() + user2.getPassword().length();

        int val = user1Comparator - user2Comparator;

        if(val == 0){
            val = user1.getUsername().compareTo(user2.getUsername());
        }
        return val;
    }
}
