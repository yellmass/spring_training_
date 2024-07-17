import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalcualtorParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {2,7,6})
    void testCase1(int num){
        assertEquals(0,num % 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Cydeo", ""})
    //@EmptySource
    //@NullSource
    @NullAndEmptySource
    void testCase2(String str){
        assertFalse(str.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase3(String str){
        assertFalse(str.isEmpty());
    }

    static String[] stringProvider(){
        return new String[]{"Java","TS","JS"};
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "10, 10, 20",
            "5, 5, 34"
    })
    void testCase4(int num1, int num2, int result){
        assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase5(int num1, int num2, int result){
        assertEquals(result, Calculator.add(num1, num2));
    }





}
