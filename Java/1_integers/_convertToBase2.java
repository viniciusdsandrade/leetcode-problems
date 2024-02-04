import java.util.Arrays;

public class _convertToBase2 {

    public static void main(String[] args) {
        int n = 1323211319;

        String binaryValue = convertToBase2(n);
        String decimalValue = convertToBase10(binaryValue);

        System.out.println("n = " + n);
        System.out.println("binaryValue = " + binaryValue);
        System.out.println("decimalValue = " + decimalValue);
    }

    public static String convertToBase2(int n) {
        if (n == 0) return "0"; // Caso especial para 0

        StringBuilder binaryValue = new StringBuilder();

        while (n > 0) {
            binaryValue.insert(0, n % 2); // Insere o bit no início da string
            n /= 2;
        }

        return binaryValue.toString();
    }

    public static String convertToBase10(String binaryString) {
        int result = 0;
        int power = 0;

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binaryString.charAt(i));
            result += (int) (digit * Math.pow(2, power));
            power++;
        }

        return String.valueOf(result);
    }
}