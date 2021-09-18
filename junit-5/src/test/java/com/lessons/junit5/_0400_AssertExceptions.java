package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 - As part of ensuring some code behaves as we expect we may that it
 - throws the exceptions we expect
*/
class _0400_AssertExceptions {

    // Assert an exception type
    @Test
    void throwy() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> { throw new RuntimeException(); }); // Notice you need curly braces
    }

    // Assert exception type and message
    @Test
    void throwyWithMessage() {
        Assertions.assertThrows(
                RuntimeException.class, this::throwing, "Something awful happened");
    }

    /*
     - Assert exception type and (expensive) message
     - Why?
        - Because lambdas are lazily evaluated
    */
    @Test
    void throwyWithExpensiveMessage() {
        Assertions.assertThrows(
                RuntimeException.class, this::throwing, () -> "Something awful happened");
    }

    // Get a handle on the exception to check for anything else
    @Test
    void getAHandle() {
        MyException ex = Assertions.assertThrows(
                MyException.class,
                this::throwingCustomException);
        Assertions.assertEquals(ex.getCode(), 5);
    }

    /*
     - BTW this will work for parent types too!
     - Why?
        - Because every MyException is a RuntimeException
        - Just like every Dog is an Animal too
    */
    @Test
    void getAHandle2() {
        RuntimeException ex = Assertions.assertThrows(
                RuntimeException.class,
                this::throwingCustomException);
        // Assertions.assertEquals(ex.getCode(), 5); // But of course we can't do this anymore
    }

    /*
     - So in light of what we have learned lets take a quick look at the signature:
        - public static <T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable)
    */

    /*
     - Let's recap a few points:
        - assertThrows will fail if the exception is not thrown at all as well as if any of your checks fail
        - We can use this method of asserting exceptions for both checked and unchecked exceptions
        - We can assert the type and the message
        - And if we want to test more such as additional members of a custom exception we can get a handle on it
        - The normal Java type hierarchies apply, so if you verify a parent type, of an exception it will pass
        - There are a few overloaded variations of assertThrows so check which fits your requirement best!
    */

    // -------------------------

    void throwing() {
        throw new RuntimeException();
    }

    static class MyException extends RuntimeException {
        int getCode() {
            return 5;
        }
    }

    void throwingCustomException() {
        throw new MyException();
    }

    public String fetchComplexMessage() {
        return "This is a hideously complex fetched from a DB :(";
    }

}
