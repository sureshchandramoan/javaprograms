package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1,2,3}, {2,3,5}
        });
    }

    private int input1,input2,result;

    public ParameterizedTest(int input1, int input2, int result) {
        this.input1 = input1;
        this.input2 = input2;
        this.result = result;
    }

    @Test
    public void testDifferentInput(){
        assertEquals(result, input1 + input2);
    }
}
