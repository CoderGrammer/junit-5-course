package com.lessons.junit5;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

/*
 - We may have a scenario where we want to test that something
   completes in an acceptable timeframe
 - Imagine you can add two numbers together with 100% accuracy
    - Great but if it takes an hour it's not much use is it!?
*/
public class _0350_AssertWithTimeouts {

    // We expect that this work should complete within the specified time limit
    @Test
    void shouldNotTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(10), () -> {
            System.out.println("hello");
        });
    }

    @Test
    void shouldNotTimeoutAndAssertResponse() {
        Integer integer = Assertions
                .assertTimeout(
                        ofSeconds(10),
                        () -> {
                           return 10;
                       });
        Assertions.assertEquals(integer , 10);
    }

    // Oh dear!
    @Test
    void shouldCompleteInTime() {
        Assertions
                .assertTimeout(
                        ofMillis(10),
                           () -> {
                               Thread.sleep(1000);
                            });
    }

    /*
     - But wait!
     - There is another flavour of timeout method!
     - Preemptive
        - So why do we care?
     - Well if the task is gonna take a long time to complete
     - The usual timeout methods will have to wait for that work to complete
     - Before the thread is released
     - But no so with pre-emptive
     - Let's give it a shot
    */

    @Test
    void potentiallyVerySlowCode() {
        Assertions
                .assertTimeout(
                        Duration.ofMillis(1),
                        () -> {
                            Thread.sleep(10000);
                            System.out.println("I'm done");
                        }
                        );
    }
    /*
     - So it waited until the code finished executing before giving us the answer
     - But wait we did get info about how long the process took
     - Now lets try with pre-emptive
    */

    @Test
    void potentiallyVerySlowCodeWithPreemptiveCheck() {
        Assertions
                .assertTimeoutPreemptively(
                        Duration.ofMillis(1),
                        () -> {
                            Thread.sleep(10000);
                            System.out.println("I'm done");
                        }
                );
    }

    /*
     - So you trade off speed for info
     - But for things which have a reasonable probability of taking a long time
     - You want to know about it quickly then go pre-emptive
     - But beware - preemptive can cause issues with ThreadLocal
     - For example this can cause issues with Springs transaction support
     - So be careful!
     - If you find yourself in this situation you can use global timeouts in
       Junit 5
     - See https://junit.org/junit5/docs/snapshot/user-guide/
        - search for 'specify global timeouts'
    */

    /*
     - What about @Timeout annotation
        - Can be used on test factories, even lifecycle methods
        - And of course normal tests
        - You can even declare it at the class level
        - This is not 'preemptive'
    */

    @Test
    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @SneakyThrows
    void myTest() {
        Thread.sleep(100);
    }

    @Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
    @Nested
    class TestClass {

        @Nested
        class SubClass {

            @Test
            @SneakyThrows
            void withTimeout() {
                Thread.sleep(100);
            }

        }

    }

}

