package com.lessons.junit5;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;


/*
 - Well we have a little trick!
    - We can change the class lifecycle ... to be once per class
    - This means we will not get a new instance per test method
    - We will just get one instance for all the test methods
    - This is fine unless you set up some state
*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class _0450_BeforeAfterMethods2 {

    List<String> names = new ArrayList<>();

    @BeforeAll
    void before() { // <- look not static!
        names.add("Dave"); // Our test fixture - setup now works as non-static!
        System.out.println("Before all");
    }

    @Test
    void addItem() {
        names.add("John");
        Assertions.assertEquals(2, names.size());
    }

    @Test
    void takeAwayItem() {
        names.add("Sally");
        names.remove("Sally");
        Assertions.assertEquals(1, names.size());
    }

    @AfterAll
    void after() {
        System.out.println("After all");
    }

}
