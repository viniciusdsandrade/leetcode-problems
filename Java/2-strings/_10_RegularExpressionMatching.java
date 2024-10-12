public class _10_RegularExpressionMatching {
    /*
    10. Regular Expression Matching
    Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Example 1
    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".

    Example 2:
    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

    Example 3:
    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".

    Constraints:
    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
     */

    /**
     * Verifica se uma string de entrada (s) corresponde a um padrão de expressão regular (p) usando uma abordagem recursiva.
     *
     * @param s A string de entrada a ser correspondida.
     * @param p O padrão de expressão regular.
     * @return true se s corresponder a p, caso contrário, false.
     */
    public static boolean isMatch2(String s, String p) {
        // Caso base: se o padrão estiver vazio, a correspondência ocorre apenas se a string também estiver vazia.
        if (p.isEmpty()) return s.isEmpty();

        // Verifica se o primeiro caractere da string corresponde ao primeiro caractere do padrão ou
        // se o padrão começa com '.'.
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // Se o segundo caractere do padrão for '*', temos duas opções:
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Opção 1: zero ocorrências do caractere anterior (ignore o caractere e a '*').
            // Opção 2: uma ou mais ocorrências (corresponda ao primeiro caractere e continue a correspondência com o mesmo padrão).
            return isMatch2(s, p.substring(2)) || (firstMatch && isMatch2(s.substring(1), p));
        } else {
            // Se não houver '*', a correspondência requer uma correspondência do primeiro caractere e uma correspondência recursiva das substrings restantes.
            return firstMatch && isMatch2(s.substring(1), p.substring(1));
        }
    }

    /**
     * Verifica se uma string de entrada (s) corresponde a um padrão de expressão regular (p) usando programação dinâmica.
     *
     * @param s A string de entrada a ser correspondida.
     * @param p O padrão de expressão regular.
     * @return true se s corresponder a p, caso contrário, false.
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // Cria uma tabela DP (m+1) x (n+1) para armazenar os resultados dos subproblemas.
        // dp[i][j] indica se a substring de s (0 a i) corresponde à substring de p (0 a j).
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Caso base: string vazia corresponde a um padrão vazio.
        dp[0][0] = true;

        // Inicializa a primeira coluna: string vazia não pode corresponder a um padrão não vazio (exceto "*").
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        // Inicializa a primeira linha: lida com padrões que começam com "*".
        // Se p[j-1] é "*", o resultado depende de dp[0][j-2] (correspondência sem o elemento anterior repetido).
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Preenche a tabela DP iterativamente.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Se os caracteres correspondem ou p[j-1] é '.', a correspondência depende do resultado do subproblema anterior.
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // Se p[j-1] é '*', existem duas opções:
                    // 1. Zero repetição do elemento anterior: a correspondência depende de dp[i][j-2].
                    dp[i][j] = dp[i][j - 2];
                    // 2. Uma ou mais repetições: a correspondência depende de dp[i-1][j] se o elemento anterior corresponder.
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Caracteres não correspondem.
                    dp[i][j] = false;
                }
            }
        }

        // O resultado está em dp[m][n], indicando se a string completa corresponde ao padrão completo.
        return dp[m][n];
    }

    public static void testIsMatch(String s, String p) {
        System.out.println("Input: s = " + s + ", p = " + p);

        long start = System.nanoTime();
        boolean output = isMatch(s, p);
        long end = System.nanoTime();

        System.out.println("Output: " + output);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
