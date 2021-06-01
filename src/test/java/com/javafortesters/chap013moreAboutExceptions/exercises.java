package com.javafortesters.chap013moreAboutExceptions;
import com.javafortesters.domainentities.InvalidPassword;
import com.javafortesters.domainentities.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class exercises {

    @Test
    public void constructUserWithException() throws InvalidPassword {
        User aUser = new User("username", "password");
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void createUserWithInvalidPasswordExceptionMessages() {
        User aUser;
        try {
            aUser = new User("username", "xx");
            aUser.setPassword("p");
            fail("An invalid password exception should have been thrown");
        } catch (InvalidPassword e) {
            assertTrue(e.getMessage().startsWith("Password must be > 6 chars"));
        }
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void createUserUsingExpectedException() throws  InvalidPassword {
        expected.expect(InvalidPassword.class);
        expected.expectMessage("> 6 chars");
        User aUser = new User("username", "< 6");
        aUser.setPassword("< 6");
    }

    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@Before each test method");
    }

    @BeforeClass
    public static void runBeforeAnyTests(){
        System.out.println("@BeforeClass any tests");
    }

    @Test
    public void testAssertMethod(){
        Integer x = 5;
        Integer y = 3;

        Integer[] numbers= new Integer[2];
        numbers[0] = x;
        numbers[1] = y;

        Integer[] numbers2 = {5, 3};


        assertEquals("x + y = 8", 8, x+y );
        assertTrue(x+y == 8);
        assertFalse(x+y == 9);
        assertNotNull(x+y);
        assertNotSame(9, x+y);
        assertArrayEquals(numbers2, numbers);


        assertThat("x + y = 8", x+y, is(8));
    }
}
