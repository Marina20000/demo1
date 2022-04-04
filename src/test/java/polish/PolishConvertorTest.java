package polish;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolishConvertorTest {
    @Test
    public void testCollectNumberAndPushToResult() {
        PolishConvertor polishConvertor = new PolishConvertor();
        List<Character> number = Arrays.asList('1', '2');
        List<String> result = new ArrayList<>();
        polishConvertor.collectNumberAndPushToResult(number, result);
        Assert.assertTrue(1 == result.size());
    }
}
