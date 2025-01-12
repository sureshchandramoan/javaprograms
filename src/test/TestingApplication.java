package test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assume.assumeTrue;

public class TestingApplication {

    @Test
    public void forLinux(){
        assumeTrue(System.getProperty("os.name").contains("linux"));
        assertEquals(15, 5+5);
    }

    @Test
    public void forWindows(){
        assumeTrue(System.getProperty("os.name").contains("Windows"));
        assertEquals(10, 5+5);
    }

    @Test
    @DisplayName("when adding 2 and 2 then the result is 4")
    public void forDisplay(){
        assertNotEquals(8, 5+5);
    }


    @Test( timeout = 7)
    public void testValidation(){
        try {
            Thread.sleep(6);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(10, 5+5);
    }

    @Test ( expected = ArithmeticException.class)
    public void forExceptionHandling() {

        int result = 5 / 0;
        assertEquals(10, result );
    }
}
