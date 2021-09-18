package com.lessons.junit5;

import org.junit.jupiter.api.Test;
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

        void emailCustomerAccountCreated() {
            print("Emailing...");
        }

    }

    static class AccountService {

        CreditCheck creditCheck;

        AccountService(CreditCheck creditCheck) {
            this.creditCheck = creditCheck;
        }

        boolean createAccount(String name) {
            if (creditCheck.passes(name)) {
                print("Creating account...");
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

    // First lets try the 'true' case
    @Test
    void withMocks() {

        CreditCheck check = Mockito.mock(CreditCheck.class);
        Emailer email = Mockito.mock(Emailer.class);



    }





    // Utility methods.................

    static void print(String s) {
        System.out.println(s);
    }

}
