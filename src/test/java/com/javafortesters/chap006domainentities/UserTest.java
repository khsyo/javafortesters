package com.javafortesters.chap006domainentities;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void createAnUsersArray(){
        User[] users = new User[3];

        users[0] = new User("bobby", "pa5440d");
        users[1] = new User("shaddy", "pa5440d");
        users[2] = new User("daddy", "pa5440d");

        assertEquals("bobby", users[0].getUsername());
        assertEquals("shaddy", users[1].getUsername());
        assertEquals("daddy", users[2].getUsername());
        System.out.print("All users look good!");
    }

    @Test
    public void printUsers(){
        User[] users = new User[3];

        users[0] = new User("bobby", "pa5440d");
        users[1] = new User("shaddy", "pa5440d");
        users[2] = new User("daddy", "pa5440d");
        for(User user : users) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void hundreduserarray() {
        User[] users = new User[100];
        for (int i = 0; i < 100; i++){
            int userId = i + 1;
            users[i] = new User("user" + userId, "password" + userId);
        }

        for (User aUser:users) {
            System.out.println(aUser.getUsername() + "," + aUser.getPassword());
        }

        int userId = 1;
        for (User aUser : users) {
            assertEquals("user" + userId, aUser.getUsername());
            userId++;
        }

        assertEquals(userId, 101);
    }

    @Test
    public void userHasDefaultUsernameAndPassword(){
//        User user = new User();
//
//        assertEquals("default username expected", "username", user.getUsername());
//        assertEquals("default user password", "password", user.getPassword());

        User newUser = new User("bobby", "password");
        assertEquals("not a default username", "bobby", newUser.getUsername());
    }

    @Test
    public void canSetPasswordAfterConstructed(){
        User user = new User();

//        user.setPassword("PaZZwor6");

        assertEquals("password is reset", "PaZZwor6", user.getPassword());
    }

    @Test
    public void IntegerTypes(){
        byte aByteHas1Byte;

        System.out.println("* `byte` range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);

        aByteHas1Byte = 0xA;
        assertEquals(9, aByteHas1Byte);
    }

    @Test
    public void CharTypes(){

        char aChar = '\u0026';
        assertEquals(aChar, '&');
    }

    @Test
    public void ConditionChecks(){

        int four = 45;
        assertTrue("The values seem equal",4 != four);
    }

    @Test
    public void TernaryChecks(){
        String url = "www.money101.com.tw";
        url = url.startsWith("https") ? url : addHttps(url);

        assertTrue("url doesn't start with https", url.startsWith("https://"));
        assertEquals("Doesn't seem right, maybe incorrect url?","https://www.money101.com.tw", url);
    }

    private String addHttps(String url){
        return "https://" + url;
    }

    private String catOrCats(int number){
        return number != 1 ? "cats" : "cat";
    }

    @Test
    public void numberOfCatsCheck(){
        int numberOfCats = 50;
        assertEquals("2 == cats", "cats", catOrCats(numberOfCats));
    }

    @Test
    public void nestedIfElse(){
//        ifElseHorror(true, true);
//        ifElseHorror(true, false);
//        ifElseHorror(false, true);
        ifElseHorror(false, false);
    }

    public void ifElseHorror(boolean truthy, boolean falsey){

        if(truthy) {
            if(falsey) {
                if(truthy && !falsey) {
                    if(falsey || truthy) {
                        System.out.println("T | F");
                        assertEquals(true, truthy);
                        assertEquals(false, falsey);
                    }
                }
            } else {
                System.out.println("T | T");
                assertTrue(truthy);
                assertTrue(falsey);
            }
        } else {
            if(!truthy) {
                if(falsey) {
                    System.out.println("F | T");
                    assertEquals(true, falsey);
                    assertEquals(false, truthy);
                } else {
                    System.out.println("F | F");
                    assertEquals(false, falsey);
                    assertEquals(false, truthy);
                }
            }
        }

    }

//    public void countryName(String countryCode) {
//        String countryName;
//
//        switch(countryCode.toLowerCase()){
//            case "uk":
//                countryName = "United Kingdom";
//                break;
//            case "us":
//                countryName = "United State";
//                break;
//            case "USA":
//                countryName = "United States";
//                break;
//            default:
//                countryName = "Rest Of World";
//                break;
//        }
//        return countryName;
//    }

}
