package com.lessons.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
 - Let's talk about lifecycle (setup/teardown) methods
 - See the diagram on slide 2550
*/
class _0830_NestedTests2 {

    // The setup methods from parent classes are executed before nested ones
    @BeforeAll
    static void preSetup() { print("-- A BeforeAll"); }

    // You can have more than one
    @BeforeAll
    static void preSetup2() { print("-- AA BeforeAll"); }

    @BeforeEach
    void setup() { print("-- -- B BeforeEach"); }

    // You can have more than one
    @BeforeEach
    void setup2() { print("-- -- BB BeforeEach"); }

    @AfterAll
    static void tear() { print("-- A AfterAll"); }

    @Nested
    class CarTests {

        /*
         - Not possible!
         - Statics not permitted in inner classes
        */
        // @BeforeAll
        // static void preSetup() { }

        @BeforeEach
        void setup() { print("-- -- -- C BeforeEach"); }

        @Test
        void lightsOn() { print("-- -- -- <LIGHTS ON>"); }

        @Nested
        class ElectricCars {
            @Test void powerUp() { print("-- -- -- -- -- -- <ELECTRIC POWER UP>");  }
        }

        @Nested
        class PetrolCars {
            @Test void startEngine() { print("-- -- -- -- -- -- <PETROL START ENGINE>");  }
        }

    }

    // Utility methods.................

    static void print(String s) {
        System.out.println(s);
    }

}
