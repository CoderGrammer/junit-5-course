package com.lessons.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.junit.jupiter.MockitoExtension;

// Let's see an example
@ExtendWith(MockitoExtension.class)
@ExtendWith(_0900_ExtensionsBasics.MyExtension.class)
class _0900_ExtensionsBasics {

    // It's just a marker interface
    @Test
    void markerInterface() {
        // org.junit.jupiter.api.extension.Extension
    }

    /*
     - How about creating our own extending Extension!
    */
    static class MyExtension implements Extension {
        MyExtension() {
            System.out.println("Not particularly useful...");
        }
    }

}












    /*
     - Questions:
         - 1. In JUnit 5 we combine Extensions with Runners to extend tests. True/False
         - 2. Only Extensions provided by the JUnit team are valid in tests. True/False
         - 3. All Extensions revolve around the unit test lifecycle. True/False
         - 4. All extensions must implement the IExtension interface from JUnit. True/False
         - Scroll down for answers
    */














    /*
     - Answers:
         - 1. In JUnit 5 we combine Extensions with Runners to extend tests. True/False
            False. You have a single API now - Extensions
         - 2. Only Extensions provided by the JUnit team are valid in tests. True/False
            False. Other teams can provide them too. You can even write your own.
         - 3. All Extensions revolve around the unit test lifecycle. True/False
            False. Some are not lifecycle related such as Exception handling ones
          - 4. All extensions must implement the IExtension interface from JUnit. True/False
            False. They must ultimately implement the Extension interface
    */