package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/*
 - Why do we even need Mockito?
    - We only want to test the 'Unit'
    - Not the dependencies
    - We need to be able to tweak the behaviour of dependencies as they can impact what our 'Unit' does
*/
class _1000_MockitoBasics {

    /*
     - Lets look at an example
    */

    static class CreditCheck {

        boolean passes(String name) { return false; }

    }

    static class Emailer {

        void emailCustomerAccountCreated(String name) {
            print("Emailing...");
        }

    }

    static class AccountService {

        CreditCheck creditCheck;
        Emailer emailer;

        AccountService(CreditCheck creditCheck, Emailer emailer) {
            this.creditCheck = creditCheck;
            this.emailer = emailer;
        }

        boolean createAccount(String name) {
            if (creditCheck.passes(name)) {
                print("Creating account...");
                emailer.emailCustomerAccountCreated(name);
                return true;
            }
            return false;
        }

    }

    /*
     - Now, when testing the AccountService how can we force the CreditCheck to return true and false for our
     - tests at will?
        - With mocks of course!
    */

    // First lets try the 'true' case - passed credit check
    @Test
    void withMocksHappyPath() {
        // Our mocks
        CreditCheck check = Mockito.mock(CreditCheck.class);
        Emailer email = Mockito.mock(Emailer.class);

        // Our service
        AccountService service = new AccountService(check, email);

        // Prep our mocks
        Mockito.when(check.passes(Mockito.anyString())).thenReturn(true);

        // Run the method we want to test
        boolean created = service.createAccount("Joe");

        // Checks
        ArgumentCaptor<String> a = ArgumentCaptor.forClass(String.class);
        Mockito.verify(email).emailCustomerAccountCreated(a.capture());
        Assertions.assertEquals("Joe", a.getValue());
        Assertions.assertTrue(true);
    }

    // First lets try the 'false' case - failed credit check
    @Test
    void withMocksUnhappyPath() {
        // Our mocks
        CreditCheck check = Mockito.mock(CreditCheck.class);
        Emailer email = Mockito.mock(Emailer.class);

        // Our service
        AccountService service = new AccountService(check, email);

        // Prep our mocks
        Mockito.when(check.passes(Mockito.anyString())).thenReturn(false);

        // Run the method we want to test
        boolean created = service.createAccount("Joe");

        // Checks
        Mockito.verifyNoInteractions(email);
        Assertions.assertFalse(created);
    }

    // Utility methods.................

    static void print(String s) {
        System.out.println(s);
    }

}
