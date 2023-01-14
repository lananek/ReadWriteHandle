package test;

import org.junit.Assert;
import org.junit.Test;
import com.company.ExpressionCalculation;
import com.company.Calculation;

public class calcTest {

    @Test
    public void testPlus() {
        Assert.assertEquals(Ideone.calc(ExpressionParser.parse("2+2")),"4.0");
    }

    @Test
    public void testMul() {
        Assert.assertEquals(Ideone.calc(ExpressionParser.parse("2*2")),"4.0");
    }

    @Test
    public void testDev() {
        Assert.assertEquals(Ideone.calc(ExpressionParser.parse("2/2")),"1.0");
    }

    @Test
    public void testPlusMul() {
        Assert.assertEquals(Ideone.calc(ExpressionParser.parse("2+2*2")),"6.0");
    }

    @Test
    public void testBrackets() {
        Assert.assertEquals(Ideone.calc(ExpressionParser.parse("(2+2)*2,"8.0");
    }

}
