public class _389_FindTheDifference {

    public static void main(String[] args) {

        testFindTheDifference("abcd", "abcde");
        testFindTheDifference("", "y");
        testFindTheDifference("a", "aa");
        testFindTheDifference("ae", "aea");
        testFindTheDifference("ae", "eaa");
        testFindTheDifference("abcd", "abcde");

    }

    public static char findTheDifference(String s, String t) {
        // Limite de borda
        if (s.length() != t.length() - 1 || s.length() > 1000 || t.length() > 1000) {
            return ' ';
        }

        // Inicializa um array de inteiros de 26 posições para armazenar a contagem de cada caractere
        int[] count = new int[26];

        // Itera sobre a string s e incrementa a contagem de cada caractere
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Itera sobre a string t e decrementa a contagem de cada caractere
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // Itera sobre o array de contagem e retorna o caractere que não foi zerado
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return (char) (i + 'a');
            }
        }

        // Se não houver diferença, retorna o último caractere de t (o que foi adicionado)
        return t.charAt(t.length() - 1);
    }



    public static void testFindTheDifference(String s, String t) {

        System.out.println("\nInput:  " + s + ", " + t);

        long start = System.nanoTime();
        char result = findTheDifference(s, t);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}