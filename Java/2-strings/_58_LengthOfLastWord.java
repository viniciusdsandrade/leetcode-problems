public class _58_LengthOfLastWord {
    public static void main(String[] args) {

//        testLengthOfLastWord("Hello World");
//        testLengthOfLastWord("   fly me   to   the moon  ");
//        testLengthOfLastWord("luffy is still joyboy");
//        testLengthOfLastWord("a");
//        testLengthOfLastWord("a ");
//        testLengthOfLastWord(" a");
//        testLengthOfLastWord("a a");
//        testLengthOfLastWord("a a ");

        testLengthOfLastWordDebug("Hello World");
        testLengthOfLastWordDebug("   fly me   to   the moon  ");
        testLengthOfLastWordDebug("luffy is still joyboy");
        testLengthOfLastWordDebug("a");
        testLengthOfLastWordDebug("a ");
        testLengthOfLastWordDebug(" a");
        testLengthOfLastWordDebug("a a");
        testLengthOfLastWordDebug("a a ");
    }

    /*
        A função devolve o tamanho da última palavra de uma string.

        1) Regras de borda:
           - Se a string for vazia (s.isEmpty()) ou maior que 10_000 caracteres,
             a função devolve 0 imediatamente. Isso evita trabalho desnecessário
             e respeita um limite superior (útil em problemas com restrição de input).

        2) Prepara um contador count = 0 para contar os caracteres da última palavra.

        3) Faz um laço de trás para frente (do último índice até 0):
           - Se o caractere atual for espaço (' ') e já temos count > 0,
             significa que acabamos de passar pela última palavra.
             Neste ponto, retornamos count (tamanho da última palavra).

           - Se o caractere não for espaço, incrementamos count,
             pois ele faz parte da última palavra.

        4) Se o laço termina sem encontrar novo espaço (ex.: a string inteira é uma palavra,
           ou há só uma palavra seguida de espaços no fim), retornamos count.

        Observações:
        - s.length() obtém o tamanho atual da string.
        - s.charAt(i) lê o caractere na posição i.
        - O percurso reverso permite ignorar facilmente os espaços à direita
          antes de começar a contar a última palavra.
    */
    public static int lengthOfLastWord(String s) {
        // Limite de borda
        if (s.isEmpty() || s.length() > 10_000) return 0;

        // Inicializa um contador
        int count = 0;

        // Itera sobre a string de trás para frente
        for (int i = s.length() - 1; i >= 0; i--) {
            // Se o caractere atual for um espaço e o contador for maior que zero, retorna o contador
            if (s.charAt(i) == ' ' && count > 0) return count;

            // Se o caractere atual for diferente de espaço, incrementa o contador
            if (s.charAt(i) != ' ') count++;
        }

        // Se o contador não for maior que zero, retorna zero
        return count;
    }

    public static int lengthOfLastWordDebug(String s, boolean debug) {
        // Guards simples
        if (s == null || s.isEmpty() || s.length() > 10_000) {
            if (debug) {
                System.out.printf("[guard] inválido: s=null? %b | vazio? %b | len=%d >10000? %b -> retorna 0%n",
                        s == null, s != null && s.isEmpty(), (s == null ? -1 : s.length()), (s != null && s.length() > 10_000));
            }
            return 0;
        }

        if (debug) {
            System.out.printf("[1] Entrada: \"%s\" (len=%d)%n", s, s.length());
        }

        int i = s.length() - 1;

        // Fase 1: ignorar espaços à direita
        int pulados = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
            pulados++;
        }
        if (debug) {
            System.out.printf("[2] Espaços à direita ignorados: %d | i=%d%n", pulados, i);
            if (i < 0) System.out.println("[2.1] String era só espaços -> retorna 0");
        }
        if (i < 0) return 0; // só espaços

        // Fase 2: contar a última palavra (até encontrar espaço ou início)
        int count = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            if (debug) {
                System.out.printf("[3.%d] char='%c' -> count=%d%n", count, s.charAt(i), count);
            }
            i--;
        }

        // Encerramento didático
        if (debug) {
            System.out.printf("[4] Parou em i=%d (%s)%n", i, (i < 0 ? "início da string" : "encontrou espaço"));
            System.out.printf("[5] Resultado: %d%n", count);
        }
        return count;
    }

    public static void testLengthOfLastWordDebug(String s) {
        System.out.println("\nInput:  " + s);

        long start = System.nanoTime();
        int result = lengthOfLastWordDebug(s, true);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }

    public static void testLengthOfLastWord(String s) {
        System.out.println("\nInput:  " + s);

        long start = System.nanoTime();
        int result = lengthOfLastWord(s);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}
