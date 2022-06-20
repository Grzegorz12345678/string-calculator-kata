import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class SimpleStringCalculatorTest {


    @Mock
    private SimpleStringCalculator calculatorMock;

    @Test
    @DisplayName("should return 5, when numbers = 2,3")
    public void test1() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2,3");
        //then
        assertEquals(5,sum);
    }

    @Test
    @DisplayName("should return 2, when numbers = 2")
    public void test2() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2");
        //then
        assertEquals(2,sum);
    }

    @Test
    @DisplayName("should return 2, when numbers = ")
    public void test3() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("");
        //then
        assertEquals(0,sum);
    }

    @Test
    @DisplayName("should return 18 when numbers = 2,2,2,2,2,8")
    public void test4() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2,2,2,2,2,8");
        //then
        assertEquals(18,sum);
    }

    @Test
    @DisplayName("should return 0 and should write operation not allowed when numbers = 2,\n3")
    public void test5() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2,\\n3");
        //then
        assertEquals(0,sum);
    }

    @Test
    @DisplayName("should return 0 and should write operation not allowed when numbers = 2\n,3")
    public void test6() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2\\n,3");
        //then
        assertEquals(0,sum);
    }

    @Test
    @DisplayName("should return 19 when numbers = 2\n3,3,2\n9")
    public void test7() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("2\\n3,3,2\\n9");
        //then
        assertEquals(19,sum);
    }

    @Test
    @DisplayName("should return 19 when numbers = //;1;2")
    public void test8() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("//;1;2");
        //then
        assertEquals(3,sum);
    }

    @Test
    @DisplayName("should return 21 when numbers = //g1g2\n4g3\n2g8\n1")
    public void test9() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("//g1g2\\n4g3\\n2g8\\n1");
        //then
        assertEquals(21,sum);
    }

    @Test
    @DisplayName("should return 17 when numbers = //g1g2\n4//aa1\n3a6")
    public void test10() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("//g1g2\\n4//aa1\\n3a6");
        //then
        assertEquals(17,sum);
    }

    @Test
    @DisplayName("should return 20 when numbers = 5//gg1g2\n4//aa1\n3a6//;;3")
    public void test11() throws NegativesNotAllowedException {
        //given + when
        int sum = calculatorMock.add("5,5//gg1g2\\n4//aa1\\n3a6//;;3");
        //then
        assertEquals(30,sum);
    }

    @Test
    @DisplayName("should return negatives not allowed[-3] when numbers = 3,-3")
    public void test12() throws NegativesNotAllowedException {
        //given + when
        Throwable exception = assertThrows(
             NegativesNotAllowedException.class,
                () -> {
                    int sum = calculatorMock.add("3,-3");
                }
        );
        //then
        assertEquals("negatives not allowed[-3]",exception.getMessage());
    }


    @Test
    @DisplayName("should return negatives not allowed[-3] when numbers = -3,-3,5,-6,9,1,-6,-8")
    public void test13() throws NegativesNotAllowedException {
        //given + when
        Throwable exception = assertThrows(
                NegativesNotAllowedException.class,
                () -> {
                    int sum = calculatorMock.add("-3,-3,5,-6,9,1,-6,-8");
                }
        );
        //then
        assertEquals("negatives not allowed[-3, -3, -6, -6, -8]",exception.getMessage());
    }


}