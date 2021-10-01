package com.lessons.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

class _0600_DisplayNames {

    /*
     - A typical test
     - Poorly named
     - Method naming does really encourage descriptive names
     - Let's see how it looks when we run it
    */
    @Test
    void accountCreation() { }

    // Well, now we can have expressive display names!
    @Test
    // Here we use 'GIVEN, WHEN, THEN' but you can say whatever you want
    @DisplayName("Given that all credit checks have passed when the user clicks " +
            "Next the account should be created")
    void accountCreation2() { }

    // Let's run these tests and see what happens

    /*
     - Finally the feature you have all been waiting for...
     - ...drum roll pls...
     - EMOJI Support...
     - On a Mac you can get emojis by pressing Ctrl+CMD+Space
     - This is mainly because JUnit 5 wanted to support Unicode so this is a nice byproduct
     - So should we use them or not?
        - Of course... why not?
        - Some symbols can actually be useful
    */
    @DisplayName("🐳🐩👺")
    @Test
    void withEmojis() { }

    /*
     - How about some different generators?
     - Note these are applied at the class level
     - Specific method level @DisplayName annotations have preference
    */

    // Replace underscores
    @Nested
    @DisplayNameGeneration(
            DisplayNameGenerator.ReplaceUnderscores.class)
    class ReplaceChars {

        @Test
        void should_return_empty_string() { }

    }

    // Generate a sentence from the type structure and method name
    @Nested
    @DisplayNameGeneration(
            DisplayNameGenerator.IndicativeSentences.class)
    class FormSentences {

        @Test
        void shouldReturnEmptyString() { }

    }

    // What if we want to configure it?
    @Nested
    @IndicativeSentencesGeneration(
            generator = DisplayNameGenerator.ReplaceUnderscores.class,
            separator = "--->")
    class FormSentencesCustomised {

        @Test
        void shouldReturnEmptyString() { }

    }

    // How about creating a custom display name generator?

    // Say we want to uppercase the class/method names...
    static class Uppercase extends DisplayNameGenerator.Simple {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return uppercase(super.generateDisplayNameForClass(testClass));
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return uppercase(super.generateDisplayNameForNestedClass(nestedClass));
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return uppercase(super.generateDisplayNameForMethod(testClass, testMethod));
        }

        private static String uppercase(String name) {
            return name.toUpperCase();
        }

    }

    @Nested
    @DisplayNameGeneration(Uppercase.class)
    class UppercaseIt {

        @Test
        void uppercase() { }
    }

    /*
     - Combine @Test with @DisplayName to form @TestWithDisplayName("Name")?
        - Nope!
            - See:
                - https://github.com/junit-team/junit5/issues/1543
                - https://github.com/junit-team/junit5/issues/614
                - https://github.com/junit-team/junit5/issues/1504
            - Essentially you would not be able to pass the name down from the new annotation to the
            - display name annotation
    */

    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @DisplayName("This is my lovely test...")
    public @interface DisplayNameTest { String value(); }

    /*
     - There is a lot more you can do
        - Setting default generators etc.
        - See the documentation here:
            - https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator
    */

}











    /*
     - Questions:
         - 1. @DisplayName can be combined with @Test to form @DisplayNameTest. True/False
         - 2. Emojis can now be used in display names. True/False
         - 3. Adding a @DisplayName annotation to your test method is optional. True/False
         - 4. You can create your own custom display name generator. True/False
         - Scroll down for answers
    */












    /*
     - Answers:
         - 1. @DisplayName can be combined with @Test to form @DisplayNameTest. True/False
            False
         - 2. Emojis can now be used in display names. True/False
            True
         - 3. Adding a @DisplayName annotation to your test method is optional. True/False
            True
         - 4. You can create your own custom display name generator. True/False
            True
    */

