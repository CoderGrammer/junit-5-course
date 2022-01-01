package com.lessons.junit5;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*
 - You can nest them arbitrarily deep (although you probably don't want to)
*/
class _0870_NestedTests4 {

    @Nested
    class Z {

        @Nested
        class Y {

            @Nested
            class X   {

                @Test
                void a() { }

            }

        }

    }

}












    /*
     - Questions:
         - 1. @BeforeAll annotated methods cannot be used in nested tests. True/False
         - 2. @BeforeEach annotated methods can be used in nested tests. True/False
         - 3. @AfterAll annotated methods run after each test. True/False
         - 4. @Nested can only be used on static nested classes. True/False
         - 5. You can nest test classes up to three levels deep. True/False
         - Scroll down for answers
    */














    /*
     - Answers:
         - 1. @BeforeAll annotated methods cannot be used in nested tests. True/False
            False. It does require changing the lifecycle though
         - 2. @BeforeEach annotated methods can be used in nested tests. True/False
            True
         - 3. @AfterAll annotated methods run after each test. True/False
            False. Only after ALL tests
         - 4. @Nested can only be used on static nested classes. True/False
            False. It can only be used on inner classes
         - 5. You can nest test classes up to three levels deep. True/False
            False. They can be nested arbitrarily deep
    */
