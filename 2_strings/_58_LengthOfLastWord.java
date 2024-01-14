public class _58_LengthOfLastWord {
    public static void main(String[] args) {

        testLengthOfLastWord("Hello World");
        testLengthOfLastWord("   fly me   to   the moon  ");
        testLengthOfLastWord("luffy is still joyboy");
        testLengthOfLastWord("a");
        testLengthOfLastWord("a ");
        testLengthOfLastWord(" a");
        testLengthOfLastWord("a a");
        testLengthOfLastWord("a a ");
    }

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
