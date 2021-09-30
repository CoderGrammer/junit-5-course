package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 - Notice the class is not public!
  - This was not possible for tests before JUnit 5 - they had to be public
  - Generally considered better to have things as private as possible
  - no modifier - aka - package-private
  - Is even more restrictive than protected
  - But remember in Java top level classes can only be public or default (no modifier)
  - Another good thing about this is less boilerplate
  - Notice the class name ends in 'Test'
  - This is not essential but advisable - some tools may expect it to end in Test
  - So the build etc. can sometimes need tweaking if you don't end with Test
*/
class _0100_AnatomyOfATest {

    /*
     - Notice no access modifier here too - same applies
     - Can also be protected
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
     - The absence of a failure is a pass!
        - You would normally see a passing assertion
        - But technically this is sufficient
    */
    @Test
    void passing() { }

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






    /*
     - Questions:
         - 1. Can a top level unit test classes be marked as protected access?
         - 2. Can test methods be marked public?
         - 3. Can test methods be marked private?
         - 4. Which is the correct JUnit 5 assertions class?
                a. org.junit.Assert
                b. org.junit.jupiter.api.Assertions
         - 5. A test with no assertions that throws no exceptions is a failing test?
                True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Can top level unit test classes be marked as protected access?
            Nope - But nested tests can be
         - 2. Can test methods be marked public?
            Yes
         - 3. Can test methods be marked private?
            Nope
         - 4. Which is the correct JUnit 5 assertions class?
                a. org.junit.Assert
                b. org.junit.jupiter.api.Assertions
            b
         - 5. A test with no assertions that throws no exceptions is a failing test?
                True/False
            False
    */




}
