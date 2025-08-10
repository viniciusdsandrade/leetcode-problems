import static java.lang.IO.println;
import static java.lang.System.nanoTime;
import static java.util.Objects.requireNonNull;
import static util.Print.printf;

public class _205_IsomorphicStrings {

    /*
    205. Isomorphic Strings
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



    Example 1:
    Input: s = "egg", t = "add"
    Output: true

    Example 2:
    Input: s = "foo", t = "bar"
    Output: false

    Example 3:
    Input: s = "paper", t = "title"
    Output: true
     */
    public static void main(String[] args) {
//        testIsIsomorphic("egg", "add");
//        testIsIsomorphic("foo", "bar");
//        testIsIsomorphic("paper", "title");

        testIsIsomorphicDebug("egg", "add");
        testIsIsomorphicDebug("foo", "bar");
        testIsIsomorphicDebug("paper", "title");
        testIsIsomorphicDebug("badc", "baba");
    }

    /**
     * Verifica se duas strings fornecidas, 's' e 't', são isomórficas.
     *
     * <p>Duas strings são consideradas isomórficas se houver uma correspondência um-para-um entre os caracteres de `s` e os caracteres de `t`.
     * Isso significa que cada caractere em `s` pode ser mapeado para um único caractere em `t` e vice-versa,
     * mantendo a ordem dos caracteres.</p>
     *
     * <p>A função utiliza dois arrays de inteiros, `sMap` e `tMap`, para rastrear o mapeamento entre os caracteres.
     * Os índices dos arrays representam os códigos ASCII dos caracteres, e os valores armazenados nos arrays indicam
     * a posição da última ocorrência do caractere na respectiva string. Um valor 0 em `sMap[i]` ou `tMap[i]` indica
     * que o caractere com código ASCII `i` ainda não foi encontrado na string correspondente.</p>
     *
     * <p>A função itera pelas strings `s` e `t` simultaneamente, caractere por caractere. Para cada par de caracteres `sChar` e `tChar`:
     * <ul>
     *     <li>Se `sMap[sChar]` for diferente de `tMap[tChar]`, isso significa que os caracteres já foram mapeados
     *     para outros caracteres ou um deles já foi mapeado enquanto o outro não, então as strings não são isomórficas e a função retorna `false`.</li>
     *     <li>Caso contrário, o mapeamento atual é válido. Os valores de `sMap[sChar]` e `tMap[tChar]` são atualizados
     *     para a posição atual (índice + 1) para indicar que este caractere foi encontrado nesta posição.</li>
     * </ul></p>
     *
     * <p>Se a função iterar por todas as strings sem retornar `false`, isso significa que um mapeamento válido foi encontrado
     * e as strings são isomórficas. Nesse caso, a função retorna `true`.</p>
     *
     * @param s A primeira string a ser comparada.
     * @param t A segunda string a ser comparada.
     * @return `true` se as strings forem isomórficas, `false` caso contrário.
     *
     * @throws NullPointerException se 's' ou 't' forem nulos.
     *
     * <p>Exemplos de uso:</p>
     * <pre>
     * isIsomorphic("egg", "add") == true // Os mapeamentos são: e->a, g->d
     * isIsomorphic("foo", "bar") == false // Não há mapeamento um-para-um possível
     * isIsomorphic("paper", "title") == true // Os mapeamentos são: p->t, a->i, e->l, r->e
     * </pre>
     */
    public static boolean isIsomorphic(String s, String t) {

        /*

           A função cria dois vetores de 256 inteiros (sMap e tMap) iniciados em 0 para registrar, por caractere ASCII, “a última posição vista + 1”.
           Em seguida, percorre os índices de 0 até s.length()-1; em cada passo, lê sChar = s.charAt(i) e tChar = t.charAt(i). Compara sMap[sChar] e tMap[tChar]:
            se forem diferentes, significa que o “histórico” desses dois caracteres não bate
           (quebraria a correspondência 1-para-1 entre os alfabetos de s e t), então retorna false imediatamente.
           Se forem iguais, atualiza ambos para i+1, marcando que esses dois caracteres voltaram a aparecer juntos nessa posição.
           Se o laço termina sem conflito, retorna true, indicando que existe um mapeamento consistente de s para t.

           Observação didática: usar dois vetores de tamanho 256 é uma técnica clássica (rápida) quando assumimos ASCII; para conjuntos maiores de caracteres (Unicode), costuma-se usar mapas/dicionários.
         */

        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap[sChar] != tMap[tChar]) return false;

            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
        }

        return true;
    }

    public static boolean isIsomorphicDebug(String s, String t) {
        requireNonNull(s, "s");
        requireNonNull(t, "t");

        println("==================================================");
        println("Debug: isIsomorphic(s, t)");
        println("s = \"" + s + "\" (len=" + s.length() + ")");
        println("t = \"" + t + "\" (len=" + t.length() + ")");

        if (s.length() != t.length()) {
            println("-> Comprimentos diferentes: resultado = false");
            println("==================================================\n");
            return false;
        }

        // Mesma estratégia do seu código: “última posição vista + 1” (0 significa “ainda não visto”)
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        println("Legenda: sMap[c] e tMap[c] guardam (índice_ultima_ocorrencia + 1).");
        println("         0 significa que o caractere ainda não apareceu.");
        println();
        printf("%-5s | %-7s | %-7s | %-12s | %-12s | %-10s%n",
                "i", "s[i]", "t[i]", "sMapAntes", "tMapAntes", "Ação");
        println("-------------------------------------------------------------------");

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Aviso simples se alguém sair do intervalo ASCII assumido (256)
            if ((sChar & 0xFF) != sChar || (tChar & 0xFF) != tChar) {
               println("[Aviso] Caractere fora do intervalo 0..255. "
                        + "Esta versão usa tabelas de 256 posições.");
            }

            int sBefore = sMap[sChar];
            int tBefore = tMap[tChar];

           printf("%-5d | %-7s | %-7s | %-12d | %-12d | ",
                    i, quote(sChar), quote(tChar), sBefore, tBefore);

            // Regra central: as “últimas posições” têm de coincidir
            if (sBefore != tBefore) {
                println("CONFLITO -> return false");
                println("Motivo: última ocorrência de '" + sChar + "' em s (" + sBefore
                        + ") != última ocorrência de '" + tChar + "' em t (" + tBefore + ")");
                println("==================================================\n");
                return false;
            }

            // Atualiza com (i + 1)
            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;
            printf("OK, atualiza p/ %d%n", (i + 1));
        }

        println("-------------------------------------------------------------------");
        println("Nenhum conflito encontrado: resultado = true");
        println("==================================================\n");
        return true;
    }

    private static String quote(char c) {
        return "'" + c + "'";
    }

    public static void testIsIsomorphic(String s, String t) {
        println("s = " + s);
        println("t = " + t);

        long start = nanoTime();
        boolean result = isIsomorphic(s, t);
        long end = nanoTime();

        println("Output = " + result);
        println("Execution time = " + (end - start) + " ns\n");
    }

    public static void testIsIsomorphicDebug(String s, String t) {
        println("s = " + s);
        println("t = " + t);

        long start = nanoTime();
        boolean result = isIsomorphicDebug(s, t);
        long end = nanoTime();

        println("Output = " + result);
        println("Execution time = " + (end - start) + " ns\n");
    }

}
