package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 - You don't want all tests to run all the time!
    - 'Conditional Execution' to the rescue...
*/
class _0500_ConditionalExecution {

    /*
     - Failing test for which the business are still unsure of the requirement...
    */
    @Disabled
    @Test
    void ambiguousTest() {
        Assertions.fail();
    }

    /*
     - IMPORTANT - Never disable a test without adding a reason!
    */
    @Disabled("Test fails and the business are in discussion about the appropriate expectation. See http...")
    @Test
    void ambiguousTest2() {
        Assertions.fail();
    }

    // Let's have a little look in this package:
    // org.junit.jupiter.api.condition
    public boolean customMethod() {
        return true;
    }

    /*
     - You can optionally use the ExtensionContext
    */
    public boolean customMethod2(ExtensionContext ex) {
        return ex.getConfigurationParameter("x")
                .filter(y -> y.equals("runAll"))
                .map(b -> Boolean.TRUE)
                .orElse(Boolean.FALSE);
    }

    /*
     - We won't go over all of them because they are fairly self-explanatory
     - But you can roll your own...
    */
    @Test
    @DisabledIf("customMethod")
    void withCustomCondition() {
        Assertions.fail("oops!");
    }

    /*
     - I noticed a peculiar quirk of IntelliJ that if you run the test directly it still runs
     - You can work around it but running the test class
     -  And anyway tests should normally run as part of a build process
    */

    /*
     - These can be used as meta annotations
        - Test with:
            - my.env.var=end
            - my.env.var=envA
    */
    @Test
    @EnabledIfEnvironmentVariable(named = "my.env.var", matches = "env.*")
    void ifEnvVar() {
        Assertions.fail();
    }

    /*
        - Test with:
            - -Dmy.sys.prop=sa
            - -Dmy.sys.prop=sysA
    */
    @Test
    @EnabledIfSystemProperty(named = "my.sys.prop", matches = "sys*")
    void ifSysProp() {
        Assertions.fail();
    }

    /*
     - Runs only if both EnabledIf* conditions match
        - How?
            - Well we can use these annotations as 'meta-annotations' to form a 'composed' annotation
        - Notice, we even composed the @Test annotation
    */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledIfSystemProperty(named = "my.sys.tests.enabled", matches = "true")
    @EnabledIfEnvironmentVariable(named = "my.env", matches = "^(?!.*(prod)).*$")
    public @interface EnabledInNonProductionEnvironments { }

    /*
     - Test with:
        - -Dmy.sys.tests.enabled=true
        - my.env=test
    */
    @EnabledInNonProductionEnvironments
    void ifEnvVarAndSysProp() {
        Assertions.assertTrue(true);
    }

}
