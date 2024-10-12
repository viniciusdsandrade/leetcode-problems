import java.util.HashMap;
import java.util.Map;

public class _166_FractionToRecurringDecimal {

    /*
    166. Fraction to Recurring Decimal

    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
    If the fractional part is repeating, enclose the repeating part in parentheses.
    If multiple answers are possible, return any of them.
    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

    Example 1:
    Input: numerator = 1, denominator = 2
    Output: "0.5"

    Example 2:
    Input: numerator = 2, denominator = 1
    Output: "2"

    Example 3:
    Input: numerator = 4, denominator = 333
    Output: "0.(012)"

    Constraints:
    -2^31 <= numerator, denominator <= 2^31 - 1
    denominator != 0
     */
    public static void main(String[] args) {
        testFractionToDecimal(1, 2);
        testFractionToDecimal(2, 1);
        testFractionToDecimal(4, 333);
    }

    /**
     * Converte uma fração em sua representação decimal.
     *
     * @param numerator   O numerador da fração.
     * @param denominator O denominador da fração.
     * @return A representação decimal da fração.
     * @see java.lang.StringBuilder
     * @see java.util.HashMap
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        // Se o numerador for 0, a fração é 0.
        if (numerator == 0) return "0";

        // Use um StringBuilder para construir eficientemente o resultado.
        StringBuilder result = new StringBuilder();

        // Se o numerador ou o denominador for negativo (mas não ambos), adicione um sinal de menos ao resultado.
        if (numerator < 0 ^ denominator < 0) result.append("-");

        // Converte numerador e denominador para valores longos absolutos para evitar overflow.
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        // Calcula a parte inteira da fração e a adiciona ao resultado.
        result.append(dividend / divisor);

        // Calcula o resto.
        long remainder = dividend % divisor;

        // Se o resto for 0, a fração é um número inteiro e podemos retornar o resultado.
        if (remainder == 0) return result.toString();

        // Se o resto não for 0, a fração tem uma parte decimal.
        result.append(".");

        // Crie um mapa para armazenar os restos e suas posições correspondentes no resultado.
        // Isso é usado para detectar partes repetitivas da fração decimal.
        Map<Long, Integer> map = new HashMap<>();

        // Continue o loop enquanto o resto não for 0.
        while (remainder != 0) {
            // Se o resto atual já estiver no mapa, encontramos uma parte repetitiva.
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");// Insira parênteses no resultado na posição onde a parte repetitiva começa.
                result.append(")"); // Adicione um parêntese de fechamento ao final do resultado.
                break; // Interrompa o loop, pois encontramos a parte repetitiva.
            }
            map.put(remainder, result.length());// Se o resto atual não estiver no mapa, adicione-o ao mapa com sua posição atual no resultado.
            remainder *= 10;  // Multiplique o resto por 10 para calcular o próximo dígito da parte decimal.
            result.append(remainder / divisor); // Adicione o próximo dígito da parte decimal ao resultado.

            remainder %= divisor; // Calcula o novo resto.
        }
        return result.toString(); // Retorna o resultado como uma string.
    }

    public static void testFractionToDecimal(int numerator, int denominator) {
        System.out.println("Numerator:      " + numerator);
        System.out.println("Denominator:    " + denominator);

        long start = System.nanoTime();
        String result = fractionToDecimal(numerator, denominator);
        long end = System.nanoTime();

        System.out.println("Output:         " + result);
        System.out.println("Time:           " + (end - start) + " ns\n");
    }
}
