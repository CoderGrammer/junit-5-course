import org.junit.Assert;
import org.junit.Test;

public class CalcJUnit4Test {

    @Test
    public void addShouldAdd() {
        Assert.assertEquals(15, Calc.add(5, 10));
    }

}
