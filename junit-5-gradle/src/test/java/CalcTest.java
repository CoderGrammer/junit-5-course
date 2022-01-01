import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalcTest {

    @DisplayName("A very basic add happy path")
    @Test
    void addShouldAdd() {
        Assertions.assertEquals(15, Calc.add(5, 10));
    }

}