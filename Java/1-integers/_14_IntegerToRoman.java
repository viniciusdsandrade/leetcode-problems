public class _14_IntegerToRoman {

    /*
    12. Integer to Roman
    
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 
    12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
    which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. 
    However, the numeral for four is not IIII. Instead, the number four is written as IV. 
    Because the one is before the five we subtract it making four. 
    The same principle applies to the number nine, which is written as IX. 
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral.

    Example 1:
    Input: num = 3
    Output: "III"
    Explanation: 3 is represented as 3 ones.

    Example 2:
    Input: num = 58
    Output: "LVIII"
    Explanation: L = 50, V = 5, III = 3.
    
    Example 3:
    Input: num = 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
    1 <= num <= 3999
     */
    public static void main(String[] args) {
        testIntToRoman(3);
        testIntToRoman(58);
        testIntToRoman(1994);
        
    }

    public static String intToRoman(int num) {
        
        if (num < 1 || num > 3999) return "";
        
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            
            if (num >= 1000) {
                sb.append("M");
                num -= 1000;
            } else if (num >= 900) {
                sb.append("CM");
                num -= 900;
            } else if (num >= 500) {
                sb.append("D");
                num -= 500;
            } else if (num >= 400) {
                sb.append("CD");
                num -= 400;
            } else if (num >= 100) {
                sb.append("C");
                num -= 100;
            } else if (num >= 90) {
                sb.append("XC");
                num -= 90;
            } else if (num >= 50) {
                sb.append("L");
                num -= 50;
            } else if (num >= 40) {
                sb.append("XL");
                num -= 40;
            } else if (num >= 10) {
                sb.append("X");
                num -= 10;
            } else if (num == 9) {
                sb.append("IX");
                num -= 9;
            } else if (num >= 5) {
                sb.append("V");
                num -= 5;
            } else if (num == 4) {
                sb.append("IV");
                num -= 4;
            } else if (num >= 1) {
                sb.append("I");
                num -= 1;
            }
        }
        return sb.toString();
    }
    
    private static void testIntToRoman(int num) {
        try {
            long startTime = System.nanoTime();
            String answer = intToRoman(num);
            long endTime = System.nanoTime();
            
            System.out.println("\nInput:  " + num);
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
        } catch (Exception e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }
}
