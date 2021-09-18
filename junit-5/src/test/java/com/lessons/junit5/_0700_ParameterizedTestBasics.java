package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 - Duplication is the cardinal sin of programming!
    - But sometimes we need to run the same test with varied data
    - Parameterized tests to the rescue!
 - NOTE: We need to bring in junit-jupiter-params dependency
*/
public class _0700_ParameterizedTestBasics {

    /*
     - Let's see an example
        - Notice you combine the @ParameterizedTest annotation with another describing the source
    */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void checkPositive(int i) {
        Assertions.assertTrue(i > 0);
    }

    /*
     - You can specify quite a few different types of sources
    */
    // org.junit.jupiter.params.provider

    /*
     - Some types you can use:
        CSV source
        CSV file source
        Enum source
        Custom method source
        Etc...
    */

}
