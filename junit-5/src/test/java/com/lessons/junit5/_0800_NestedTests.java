package com.lessons.junit5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
 - Sometimes you want to create a sub-group of related tests
 - And you may want to share setup/instance vars with any enclosing class
 - Lets see an example...
*/
class _0800_NestedTests {

    @BeforeAll
    static void preSetup() { System.out.println("A"); }

    @Nested
    class CarTests {

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

}
