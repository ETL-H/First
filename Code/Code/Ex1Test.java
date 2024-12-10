package Code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits.
 */
public class Ex1Test {

    // Test the conversion of a binary string to an integer
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);

        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);

        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }

    // Test if numbers in valid and invalid formats are identified correctly
    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i++) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i++) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }
    }

    // Test conversion from int to string representation in various bases
    @Test
    void int2NumberTest() {
        String[] numbers = {"15bD", "1234b5", "5454bC", "123", "ABbG", "11101b2"};
        String[] base10 = {"18", "194", "9280", "123", "171", "29"};
        boolean flag = true;

        for (int i = 0; i < numbers.length; i++) {
            if (!Ex1.equals(numbers[i], base10[i])) {
                flag = false;
            }
        }

        assertTrue(flag);
        assertEquals(Ex1.int2Number(255, 16), "FFbG"); // Decimal to hexadecimal
        assertEquals(Ex1.int2Number(7, 2), "111b2"); // Decimal to binary
    }

    // Test finding the maximum number's index in a list
    @Test
    void maxIndexTest() {
        String[][] numbersToTest = {
                {"123", "122", "122", "12b3"},
                {"599", "12bD", "599bG", "100b2"},
                {"15bG", "0", "1", "13"},
                {"555", "555b6", "555b7", "555bG"}
        };
        int[] numbersAnswers = {123, 1433, 21, 1365};
        boolean flag = true;

        for (int i = 0; i < numbersToTest.length; i++) {
            int res = Ex1.maxIndex(numbersToTest[i]);
            int compare = numbersAnswers[i];
            int result = Ex1.number2Int(numbersToTest[i][res]);
            if (result != compare) {
                flag = false;
            }
        }

        assertTrue(flag);
    }

    // Additional Tests
    // Test edge cases for number2Int()
    @Test
    void number2IntEdgeCasesTest() {
        assertEquals(Ex1.number2Int("0b2"), 0); // Zero in binary
        assertEquals(Ex1.number2Int("FFFFbG"), 65535); // Large hexadecimal number
        assertEquals(Ex1.number2Int("000bA"), 0); // Leading zeros
        assertEquals(Ex1.number2Int("1b1"), -1); // Invalid base
    }

    // Test edge cases for isNumber()
    @Test
    void isNumberEdgeCasesTest() {
        assertTrue(Ex1.isNumber("0b2")); // Zero in binary
        assertFalse(Ex1.isNumber("b")); // Invalid format
        assertTrue(Ex1.isNumber("ABCDEbG")); // Valid large base
        assertFalse(Ex1.isNumber("123b17")); // Invalid base
    }


    // Test edge cases for equals()
    @Test
    void equalsEdgeCasesTest() {
        assertTrue(Ex1.equals("10bA", "10")); // Decimal equality
        assertTrue(Ex1.equals("11b2", "3")); // Binary equals decimal
        assertTrue(Ex1.equals("FFbG", "255")); // Hexadecimal equals decimal
        assertFalse(Ex1.equals("10bA", "10bB")); // Different bases
    }
}
