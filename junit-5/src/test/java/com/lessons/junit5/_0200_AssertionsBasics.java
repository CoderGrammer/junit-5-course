package com.lessons.junit5;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 - Some of this was covered in the previous section
    - But as we are talking about assertions we may recap a little
*/
class _0200_AssertionsBasics {

    /*
     - First things first:
        - we want assertions from the right place
        - it may still work if you mix JUnit 4 assertions
          with a JUnit 5 annotated test, but it's not advisable
    */
    @Test
    void theRightImports() {
        // JUnit 5
        // org.junit.jupiter.api
        Assertions.assertTrue(true);

        // JUnit 4
        // org.junit
        // Notice the IDE warning...
        Assert.assertTrue(true);
    }

    /*
     - Every method is static
    */
    @Test
    void allStatics() {
        // Assertions.*

        // This means, using static imports you can be less verbose:
        assertNotEquals(1, 5);
    }

    /*
     - We could, static import all assertions:
        - import static org.junit.jupiter.api.Assertions.*;
        - But some IDEs make light work of it anyway
    */

    /*
     - It's worth exploring the variety of assertion methods available
    */
    @Test
    void lotsOfOptions() {
        Assertions.assertEquals(5, 2);
        Assertions.assertNotEquals(5, 2);
        Assertions.assertLinesMatch(List.of(), List.of());
    }

    /*
     - In the previous section we saw custom test failure messages
     - How about a message that takes some resource to compute...
    */
    @Test
    void lazyMessages() {
        // Lets be lazy...
        String expensiveValueFromDb = "...";
        assertTrue(false, () -> String.format("This customer is in an inconsistent state %s", expensiveValueFromDb));
    }

}







    /*
     - Questions:
         - 1. How can you import all the static methods from the Assertions class?
         - 2. Why would you use a lambda for a custom failure message?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. How can you import all the static methods from the Assertions class?
            - Using import static org.junit.jupiter.api.Assertions.*;
         - 2. Why would you use a lambda for a custom failure message?
            - Because lambdas have the benefit of being lazy evaluated, so it could improve performance
    */



