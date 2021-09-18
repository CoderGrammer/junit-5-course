package com.lessons.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
 - Let's talk about lifecycle (setup/teardown) methods
*/
class _0830_NestedTests2 {

    @BeforeAll
    static void preSetup() { print("- A BeforeAll Outer"); }

    @BeforeEach
    void setup() { print("- B BeforeEach Outer"); }

    @Nested
    class CarTests {

        /*
         - Not possible!
         - Statics not permitted in inner classes
        */
        // @BeforeAll
        // static void preSetup() { }

        @BeforeEach
        void setup() { print("----- C BeforeEach Middle"); }

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

    static void print(String s) {
        System.out.println(s);
    }

}
