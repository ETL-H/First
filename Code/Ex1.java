package assignments.ex1.Code;

import java.util.ArrayList;

/**
 * Class implementing number format conversion and basic arithmetic for bases [2,16].
 */
public class Ex1 {

    /**
     * Splits the input string into a number and its base.
     * @param input The input string representing a number in a specific base.
     * @return An array containing the number and base, or {-1, -1} for invalid input.
     */
    public static String[] input2NumAndBase(String input) {
        ArrayList<String> result = new ArrayList<String>();
        int count = 0;
        input = input.strip();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'b')
                count++;
        }
        int lastb = input.lastIndexOf('b');
        if (input.length() == 1) {
            String chars = "0123456789";
            if (!chars.contains(input)) {
                String[] quit;
                quit = new String[]{"-1", "-1"};
                return quit;
            } else {
                String[] quit;
                quit = new String[]{input, "10"};
                return quit;
            }
        }
        if (count == 1 && lastb == input.length() - 2 && input.length() > 1 && lastb != 0) {
            int numLen = input.length();
            String num = input.substring(0, numLen - 2);
            String base = input.substring(numLen - 1);
            result.add(num);
            result.add(base);
        } else if (lastb == -1) {
            result.add(input);
            result.add("A");
        } else {
            result.add("-1");
            result.add("-1");
        }

        String[] finalResult = result.toArray(String[]::new);
        String chars = "ABCDEFG";
        String chars2 = "0123456789";
        if (chars2.contains(finalResult[1])) {
            return finalResult;
        }
        if (chars.contains(finalResult[1])) {
            finalResult[1] = String.valueOf(finalResult[1].charAt(0) - 55);
        } else {
            finalResult[1] = "-1";
        }
        return finalResult;
    }

    /**
     * Converts a formatted number string into its decimal integer value.
     * @param num The input number as a string.
     * @return The decimal integer value, or -1 if invalid.
     */
    public static int number2Int(String num) {
        if (isNumber(num)) {
            String number = input2NumAndBase(num)[0];
            String base = input2NumAndBase(num)[1];
            int sBase = Integer.parseInt(base);
            int dBase = 10;
            if (!Integer.toString(sBase).equals("-1"))
                return Integer.parseInt(Integer.toString(Integer.parseInt(number, sBase), dBase));
        }
        return -1;
    }

    /**
     * Checks if the given string represents a valid number in the required format.
     * @param a The input string.
     * @return True if valid, false otherwise.
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        int count = 0;
        int base = 10;
        String number = "";
        int lastb = a.lastIndexOf('b');
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'b')
                count++;
        }
        if (a.isEmpty() || hasSpace(a)) {
            return false;
        } else {
            if (count == 0) {
                base = 10;
                number = a;
            } else if (count == 1 && lastb == a.length() - 2 && a.length() > 1) {
                base = Integer.parseInt(input2NumAndBase(a)[1]);
                number = input2NumAndBase(a)[0];
            } else {
                return false;
            }
            for (char c : number.toCharArray()) {
                int digitValue = Character.isDigit(c)
                        ? c - '0' // Convert '0'-'9' to 0-9
                        : c - 'A' + 10; // Convert 'A'-'G' to 10-16

                // Check if the digit is valid for the base
                if (digitValue < 0 || digitValue >= base) {
                    return false; // Invalid digit
                }
            }

            return ans; // All digits are valid
        }
    }

    /**
     * Converts a decimal integer to its string representation in the specified base.
     * @param num The decimal integer.
     * @param base The base for conversion.
     * @return The number in the specified base, or an empty string if invalid.
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        String sNum = String.valueOf(num);
        int sBase = Integer.parseInt((input2NumAndBase(sNum)[1]));
        char charBase = (char)base;
        String strBase = String.valueOf(base);
        ans = Integer.toString(Integer.parseInt(String.valueOf(num), sBase), base);
        ans = ans.toUpperCase();
        for (int i = 10; i <= 16; i++){
            if(base == i){
                charBase += 55 ;
                strBase = String.valueOf(charBase);
            }
        }
        if(base != 10){
            ans += "b" + strBase;
        }
        return ans;
    }

    /**
     * Checks if two numbers are equal in value.
     * @param n1 The first number.
     * @param n2 The second number.
     * @return True if equal, false otherwise.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        int firstNumber = number2Int(n1);
        int secondNumber = number2Int(n2);
        if(firstNumber != secondNumber){
            ans = false;
        }
        return ans;
    }

    /**
     * Finds the index of the maximum number in an array.
     * @param arr An array of numbers as strings.
     * @return The index of the maximum number.
     */
    public static int maxIndex(String[] arr) {
        int arrII = -1;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int arrI = number2Int(arr[i]);
            if (arrII < arrI) {
                ans = i;
                arrII = arrI;
            }
        }
        return ans;
    }

    /**
     * Checks if a string contains any spaces.
     * @param input The input string.
     * @return True if spaces are present, false otherwise.
     */
    public static boolean hasSpace(String input) {
        boolean hasSpace = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                hasSpace = true;
                break;
            }
        }
        return hasSpace;
    }
}
