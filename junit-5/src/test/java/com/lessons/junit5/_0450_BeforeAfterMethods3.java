package com.lessons.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/*
 - How about doing something before or after each test method executes?
 - BeforeEach and afterEach to the rescue...
*/
class _0450_BeforeAfterMethods3 {

    @BeforeEach
    void before() {
        System.out.println("a");
    }

    @Test
    void passingTest() { }

    // What about parameterized methods?
    // What do you think will happen?
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void checkPositive(int i) {
        Assertions.assertTrue(i > 0);
    }

    @AfterEach
    void after() {
        System.out.println("b");
    }

    /*
     - But wait!
        - These have the opposite requirement - they cannot be static!
    */

}

