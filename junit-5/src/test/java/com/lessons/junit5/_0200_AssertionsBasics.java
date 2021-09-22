package com.lessons.junit5;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
