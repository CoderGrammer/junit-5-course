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

// ######## Setup Methods / statics / which ones run
/*
 -

 - Lets see the example below...
 - What about setup methods?
 - A word about lifecycles... see below 'Lifecycles' section
 - You can nest them arbitrarily deep (although you probably don't want to)
*/

public class _0830_NestedTests2 {

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

    static void print(String s) {
        System.out.println(s);
    }

}
