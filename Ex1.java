package assignments.ex1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
        /**
         * Convert the given number (num) to a decimal representation (as int).
         * It the given number is not in a valid format returns -1.
         * @param //num a String representing a number in basis [2,16]
         * @return
         */
        public static String[] input2NumAndBase(String input){
            ArrayList<String> result = new ArrayList<String>();
            int count = 0;
            for(int i=0; i < input.length(); i++)
            {    if(input.charAt(i) == 'b')
                count++;
            }
            int lastb = input.lastIndexOf('b');
            if(input.length() == 1){
                String chars = "123456789";
                if(!chars.contains(input)){
                    String[] quit;
                    quit = new String[]{"-1", "-1"};
                    return quit;
                }
                else{
                    String[] quit;
                    quit = new String[]{input, "A"};
                    return quit;
                }
            }
            if(lastb == input.length() - 2 && count == 1) {
                int numLen = input.length();
                String num = input.substring(0, numLen - 2);
                String base = input.substring(numLen - 1);
                result.add(num);
                result.add(base);
            }
            else if (lastb == -1) {
                result.add(input);
                result.add("A");
            }
            else {
                result.add("-1");
                result.add("-1");
            }

            String[] finalResult = result.toArray(String[]::new);
            System.out.println(result);
            return finalResult;
        }


        public static int number2Int(String num) {
            String chars1 = "123456789";
            String chars2 = "ABCDEFG";
            String number = input2NumAndBase(num)[0];
            int sBase;
            String base = input2NumAndBase(num)[1];
            sBase = base.charAt(0);
            if (base.equals("-1")){
                return -1;
            }
            else if (chars1.contains(base)){
                sBase -= 48;
            }
            else if (chars2.contains(base)) {
                sBase -= 55;
            }
            int dBase = 10;
            return Integer.parseInt(Integer.toString(Integer.parseInt(number, sBase), dBase));

        }
        /**
         * This static function checks if the given String (g) is in a valid "number" format.
         * @param a a String representing a number
         * @return true iff the given String is in a number format
         */
        public static boolean isNumber(String a) {
            boolean ans = true;
            int lastB = a.lastIndexOf('b');
            String chars = "123456789ABCDEFG";
            String str_base = input2NumAndBase(a)[1];
            String[] newChars = chars.split(str_base);
            String numberWithoutBase = a.substring(0, a.length()-2);
            String[] theInput = numberWithoutBase.split("");
            if(lastB == -1){
                for (int i = 0; i < theInput.length && ans; i = i + 1){
                    if(!(Arrays.toString(newChars).contains(theInput[i]))){
                        return false;
                    }
                }
                return true;
            }
            else if (lastB != a.length() - 2){//&& the rest of numbers are valid)
                return false;
            }
            else {
                for (int i = 0; i < theInput.length && ans; i = i + 1) {
                    if (!(Arrays.toString(newChars).contains(theInput[i]))) {
                        ans = false;
                    }
                }
                return ans;
            }
        }

        /**
         * Calculate the number representation (in basis base)
         * of the given natural number (represented as an integer).
         * If num<0 or base is not in [2,16] the function should return "" (the empty String).
         * @param num the natural number (include 0).
         * @param base the basis [2,16]
         * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
         */
        public static String int2Number(int num, int base) {
            String ans = "";
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * Checks if the two numbers have the same value.
         * @param n1 first number
         * @param n2 second number
         * @return true iff the two numbers have the same values.
         */
        public static boolean equals(String n1, String n2) {
            boolean ans = true;
            // add your code here

            ////////////////////
            return ans;
        }

        /**
         * This static function search for the array index with the largest number (in value).
         * In case there are more than one maximum - returns the first index.
         * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
         * @param arr an array of numbers
         * @return the index in the array in with the largest number (in value).
         *
         */
        public static int maxIndex(String[] arr) {
            int ans = 0;
            // add your code here

            ////////////////////
            return ans;
        }
}