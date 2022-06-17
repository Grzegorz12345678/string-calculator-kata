import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class SimpleStringCalculatorTest {


    @Mock
    private SimpleStringCalculator calculatorMock;

    @Test
    @DisplayName("should return 5, when numbers = 2,3")
    public void test1(){
        //given + when
        int sum = calculatorMock.add("2,3");
        //then
        assertEquals(5,sum);
    }

    @Test
    @DisplayName("should return 2, when numbers = 2")
    public void test2(){
        //given + when
        int sum = calculatorMock.add("2");
        //then
        assertEquals(2,sum);
    }

    @Test
    @DisplayName("should return 2, when numbers = ")
    public void test3(){
        //given + when
        int sum = calculatorMock.add("");
        //then
        assertEquals(0,sum);
    }


}