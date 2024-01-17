import java.util.HashMap;

public class _168_ExcelSheetColumnTitle {
    
    /*
    168. Excel Sheet Column Title
    
    Given an integer columnNumber, return its corresponding column title 
    as it appears in an Excel sheet.
    
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
    Input: columnNumber = 1
    Output: "A"
    
    Example 2:
    Input: columnNumber = 28
    Output: "AB"
    
    Example 3:
    Input: columnNumber = 701
    Output: "ZY"
     
    Constraints:
    1 <= columnNumber <= 2^31 - 1
     */

    public static void main(String[] args) {

        testConvertToTile(1);
        testConvertToTile(28);
        testConvertToTile(52);
        testConvertToTile(53);
        testConvertToTile(701);
        testConvertToTile(2147483647);
    }

    public static String convertToTitle(int columnNumber) {

        if (columnNumber < 1) return null;

        // Cria um mapa para associar números inteiros a strings representando letras (A-Z)
        HashMap<Integer, String> map = new HashMap<>();

        // Preenche o mapa com as letras correspondentes aos números de 1 a 26
        for (int i = 1; i <= 26; i++) 
            map.put(i, String.valueOf((char) (i + 64)));
        
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            // Calcula o resto da divisão por 26 e atualiza o número da coluna
            int remainder = columnNumber % 26;
            columnNumber = columnNumber / 26;

            System.out.println("remainder: " + remainder);
            System.out.println("columnNumber: " + columnNumber);

            // Verifica se o resto é zero (caso especial)
            if (remainder == 0) {
                // Adiciona a letra correspondente a 26 (Z) e ajusta o número da coluna
                sb.append(map.get(26));
                columnNumber--;
            } else {
                sb.append(map.get(remainder)); // Adiciona a letra correspondente ao resto
            }
        }
        // Inverte a string construída e a retorna
        return sb.reverse().toString();
    }

    public static void testConvertToTile(int columnNumber) {
        System.out.println("\nInput: " + columnNumber);

        long start = System.nanoTime();
        String result = convertToTitle(columnNumber);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}
