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
        testIsIsomorphic("egg", "add");
        testIsIsomorphic("foo", "bar");
        testIsIsomorphic("paper", "title");
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

    public static void testIsIsomorphic(String s, String t) {
        System.out.println("s = " + s);
        System.out.println("t = " + t);

        long start = System.nanoTime();
        boolean result = isIsomorphic(s, t);
        long end = System.nanoTime();

        System.out.println("Output = " + result);
        System.out.println("Execution time = " + (end - start) + " ns\n");
    }
}
