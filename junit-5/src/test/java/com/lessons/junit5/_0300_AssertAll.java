package com.lessons.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _0300_AssertAll {

    /*
     - In the past with JUnit 4 if you had a test with multiple assertions
     - If any of them fail the rest are not even checked
     - Now we have a built-in solution to this problem
    */

    @Test
    void replicatingTheIssue() {
        assertTrue(true);
        assertTrue(false);
        assertTrue(false);
        assertTrue(false);
    }

    @Test
    void voidAssertAllToTheRescue() {
        assertAll(
            () -> assertTrue(true),
            () -> assertTrue(false),
            () -> assertTrue(false),
            () -> assertTrue(false));
    }

    /*
     - You can optionally provide a heading for the group
    */
    @Test
    void withAHeading() {
        assertAll("Heading...",
                () -> assertTrue(true),
                () -> assertTrue(false),
                () -> assertTrue(false),
                () -> assertTrue(false));
    }


    /*
     - AssertAll is itself an assertion
    */
    @Test
    void nestedAssertions() {
        /*
         - In this example we have an assertAll but there is only one lambda
         - Therefore it is pointless
         - assertAll collates all top level lambdas
         - but there is only one here!
         - The individual assertion failures will not be collated
        */
        assertAll(() -> { // Note this is a multiline lambda
                      assertTrue(false); // What happens when we change this to false? Remember it's a single lambda
                      assertAll(
                              () -> assertTrue(false),
                              () -> assertTrue(false),
                              () -> assertTrue(false));
                  });
    }

    /*
     - There are a fair few ways we can group and build up our assertions
    */
    @Test
    void thisMakesMoreSense() {
        // All the assertions at the top level of this assertAll will be collated
        assertAll(
                () -> {
                    // In this multi-line lambda they won't be collated
                    assertTrue(true, "1");
                    // If this get as far as this... then the following 3 will be collated
                    assertAll(
                            () -> assertTrue(false, "2"),
                            () -> assertTrue(false, "3"),
                            () -> assertTrue(false, "4"));
                },
                () -> assertTrue(false, "5"),
                () -> assertTrue(false, "6"),
                /*
                 - assertAll can be used here as normal
                 - It doesn't make great sense because they could just be part of the outer
                 - assertAll
                 - Unless you want them grouped and reported separately
                */
                () -> assertAll("Group...",
                        () -> assertTrue(false, "7"),
                        () -> assertTrue(false, "8")));
    }

    /*
     - You don't need to remember all these permutations
     - Just be aware that you have options to build up your assertions as it
     - makes sense for your use case
     - but it usually makes sense to err on the side of simplicity
    */

}



















    /*
     - Questions:
         - 1. assertAll will collate all assertions that appear underneath it? True/False
         - 2. assertAll must specify a unique group for each group of assertions? True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. assertAll will collate all assertions that appear underneath it? True/False
            False
         - 2. assertAll must specify a unique group for each group of assertions? True/False
            False
    */
