package com.lessons.junit5;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

/*
 - @BeforeEach, @BeforeAll, @AfterEach, @AfterAll
 - Methods with these annotations are referred to as lifecycle methods
 - Why do we even need these methods?
    - Well sometimes we need to set up for a test
        - This setup can be referred to as a 'test fixture'
        - You want to set up a known state or environment in which your tests run reliably
    - We also might need to a tidy up after a tests
        - This can also be referred to as 'tearing down' the setup or fixture
*/
class _0450_BeforeAfterMethods {

    /*
     - Let's take a look at BeforeAll and AfterAll first
    */
    @BeforeAll
    static void before() {
        // Setup any expensive resources here
        // External connections
        // Repeated state requirements etc
        System.out.println("Before all");
    }

    @Test
    void passingTest() { }

    @AfterAll
    static void after() {
        // Tear down / clean up any resources
        // Release / close any connections
        System.out.println("After all");
    }

    /*
     - But wait!
        - What if we don't want these methods to be static?
            - e.g. if we wanted to populate an instance variable...
            - hmmmm....
    */

}
