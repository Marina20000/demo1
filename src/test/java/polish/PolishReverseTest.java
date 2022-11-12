package polish;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PolishReverseTest {
    private PolishReverse polishReverse;
    private String in;
    private Double expectedOut;
    private Class<? extends Exception> expectedException;
    private String cause;

    public PolishReverseTest(String in, Double expectedOut,Class<? extends Exception> expectedException,String cause ) {
        this.in=in;
        this.expectedOut=expectedOut;
        this.expectedException=expectedException;
        this.cause=cause;
    }
    @Parameterized.Parameters(name="{index}: in:{1}, expectedOut:{2},expectedException:{3},cause:{4}")
    public static List<Object[]> data(){
        String in1="2 4 5 2 * / 10 + ";
        String in2="2 3 + 4 + *";
        String in3="2,3 4 +";
        String in4="";
        String in5="35+(4";
        String in6="2 - 4 / (5 *2) + 10";
        double expectedOut1=0;
        double expectedOut2=0;
        double expectedOut3=0;
        double expectedOut4=0;
        double expectedOut5=0;
        double expectedOut6=10.5;


        return Arrays.asList( new Object[][]{
                {in1,expectedOut1,CalculatorException.class,"не хватает знаков операций"},
                {in2,expectedOut2,CalculatorException.class,"не хватает операндов"},
                {in3,expectedOut3,CalculatorException.class,"в записи присутствуют недопустимые символы"},
                {in4,expectedOut4,CalculatorException.class,"не введено выражение"},
                {in5,expectedOut5,CalculatorException.class,"лишние скобки"},
                {in6,expectedOut6,null,""},

        });
    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void init() throws CalculatorException {
        polishReverse = new PolishReverse();
        if (expectedException != null) {
            thrown.expect(expectedException);
            thrown.expectMessage(cause);
        }
        Double result =polishReverse.calculate(polishReverse.parseExpression(in));
        assertEquals("calculation result is not as", expectedOut,result);

    }
}
