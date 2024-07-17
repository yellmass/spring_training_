import org.junit.jupiter.api.Test;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add(){
        int actual = Calculator.add(2,3);
        assertEquals(5,actual);
    }

    @Test
    void testCase1(){
        assertTrue(Calculator.operator.equals("abc"));
        assertEquals("abc",Calculator.operator);
    }

    @Test
    void testCase2(){
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
    }

    @Test
    void testCase3(){
        String var1 = null;
        String var2 = "abc";

        assertNull(var1);
        assertNotNull(var2);
    }

    @Test
    void testCase4(){
        Calculator obj1 = new Calculator();
        Calculator obj2 = obj1;
        Calculator obj3 = new Calculator();

        assertSame(obj1,obj2);
        assertNotSame(obj1,obj3);
    }

    @Test
    void testCase5(){
        System.out.println("test case 1 running...");
        //fail("test case 1 failed");
    }

    @Test
    void method1() {
        assertThrows(IllegalAccessException.class, () -> Calculator.method1(true));
        //assertThrows(AccessDeniedException.class, () -> Calculator.method1(true));
        //assertThrows(IllegalAccessException.class, () -> Calculator.method1(false));

    }
}