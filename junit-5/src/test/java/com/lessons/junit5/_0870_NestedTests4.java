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
            class X {

                @Test
                void a() { }

            }

        }

    }

}
