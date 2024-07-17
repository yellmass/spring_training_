import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalcualtorParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {2,7,6})
    void testCase1(int num){
        assertEquals(0,num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Cydeo", ""})
    void testCase1(String str){
        assertFalse(str.isEmpty());
    }





}
