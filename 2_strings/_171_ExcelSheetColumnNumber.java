public class _171_ExcelSheetColumnNumber {

    /*
    
    Given a string columnTitle that represents the column title as appears 
    in an Excel sheet, return its corresponding column number.

    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
      
    Example 1:
    Input: columnTitle = "A"
    Output: 1
    
    Example 2:
    Input: columnTitle = "AB"
    Output: 28
    
    Example 3:    
    Input: columnTitle = "ZY"
    Output: 701
     
    Constraints:
    1 <= columnTitle.length <= 7
    columnTitle consists only of uppercase English letters.
    columnTitle is in the range ["A", "FXSHRXW"].
     */
    public static void main(String[] args) {
        testTitleToNumber("A");
        testTitleToNumber("AB");
        testTitleToNumber("ZY");
        testTitleToNumber("FXSHRXW");
    }

    public static int titleToNumber(String columnTitle) {

        if (columnTitle == null || columnTitle.length() > 7) return 0;

        int result = 0;
        int power = 0;

        // Loop que percorre cada caractere da string columnTitle, começando pelo último
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            // Calcula o valor da letra, subtraindo 64 do valor ASCII do caractere
            int charValue = columnTitle.charAt(i) - 64;

            // Multiplica o valor da letra pela potência de 26 e adiciona ao resultado acumulado
            result += (int) (charValue * Math.pow(26, power));

            // Incrementa a potência para a próxima iteração do loop
            power++;
        }

        // Retorna o resultado final da conversão
        return result;
    }

    public static void testTitleToNumber(String columnTitle) {
        System.out.println("\nInput: " + columnTitle);

        long start = System.nanoTime();
        int result = titleToNumber(columnTitle);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}