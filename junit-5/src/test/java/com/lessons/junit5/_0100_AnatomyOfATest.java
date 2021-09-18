package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 - Notice the class is not public!
  - Generally considered better to have things as private as possible
  - no modifier - aka - package-private
  - Is even more restrictive than protected
  - But remember in Java top level classes can only be public or default (no modifier)
  - Another good thing about this is less boilerplate
  - Notice the class name ends in 'Test'
  - This is not essential but advisable - we will cover why later on
*/
class _0100_AnatomyOfATest {

    /*
     - Notice no access modifier here too - same applies
    */
    @Test
    void myDumbTest() {
        Assertions.assertTrue(true);
    }

    /*
     - Assertions are static
     - So you can use static imports
     - You can find them at class: 'org.junit.jupiter.api.Assertions'
     */
    @Test
    void myDumbTest2() {
        assertTrue(true); // static import
    }

    /*
     - Be careful not to get them from JUnit 4... org.junit.*
    */
    @org.junit.Test // JUnit 4 annotation
    void notJunit4() {
        org.junit.Assert.assertTrue(1 == 1); // JUnit 4 static method
    }

    /*
     - An example failing test
    */
    @Test
    void failing() {
        Assertions.assertEquals("a", "not-a");
        // We get the gist of the problem
        // but not a huge about of context if it were needed...
    }

    /*
     - Having a message
        - Only displayed when there is a failure
        - Ideally something that explains what went wrong
        - But with added context
    */
    @Test
    void assertionWithAMessage() {
        var expected = "Expected";
        var actual = "Actual";
        // Not massively useful example:
        assertEquals(expected, actual, "Doh! The expected did not match the actual!");
        // Can be helpful to include useful params / context
        // But don't forget the assertion failure will detail the discrepancy usually
        assertEquals(expected, actual, String.format("This failure may be caused by %s being corrupted", actual));
    }

}
