package com.lessons.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

public class _0850_NestedTests3 {

    // ######## lifecycle / questions

    @BeforeAll
    static void preSetup() { print("A"); }

    @BeforeEach
    void setup() { print("B"); }

    @Nested
    class CarTests {

        /*
         - Not possible!
         - Statics not permitted in inner classes
        */
        // @BeforeAll
        // static void preSetup() { }

        @BeforeEach
        void setup() { print("C"); }

        @Test
        void lightsOn() { }

        @Nested
        class ElectricCars {

            @Test void powerUp() { }
        }

        @Nested
        class PetrolCars {
            @Test void startEngine() { }
        }

    }

    /*
     - @Nested can only be used on non-static nested classes
     - In other words 'inner' classes
    */
    @Nested
    class NonStatic { @Test void tst() { } }

    /*
     - Static nested classes will be ignored
    */
    @Nested
    static class ImStatic { @Test void tst() { } }

    static void print(String s) {
        System.out.println(s);
    }

    /*
     - Lifecycles
        - A bit like the circle of life from the Lion King!
        - JUnit creates instances of test classes
        - But it creates a new one for each test
        - That's why you can have instance state, and it causes no problems
    */

    /*
     - With this annotation setting there will only be one instance
     - Therefore suddenly the before/after All methods don't need to be static
     - So they can be used on nested classes
    */
    @TestInstance(PER_CLASS)
    @Nested
    class TestWithInstanceState {

        List<String> names = new ArrayList<>();

        /*
         - Look now we can use @BeforeAll
         - As it does not need to be static
        */
        @BeforeAll
        void setup() { print("D"); }

        @Test
        void test1() {
            names.add("ayesha");
            assertEquals(1, names.size());
        }

        /*
         - This test fails because it has to take into account the
         - lingering effects of another test
         - This situation gets worse the more tests there are
         - interacting with state
        */
        @Test
        void test2() {
            names.add("joe");
            names.add("aisha");
            assertEquals(2, names.size());
        }

    }

    /*
     - Let's summarise the last part:
        - If you want to use @BeforeAll in a @Nested class:
            - You need to use:
                @TestInstance(PER_CLASS)
        - Otherwise:
            - You cannot use @BeforeAll on @Nested classes
            - And you have the default:
                @TestInstance(PER_METHOD)
    */
}
