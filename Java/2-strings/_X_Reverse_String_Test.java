public class _X_Reverse_String_Test {
    public static void main(String[] args) {

        String nome = "Vinícius dos Santos Andrade";
        String gigante = nome.repeat(20000);

        long start_1 = System.nanoTime();
        String reversed_1 = reverseString(nome);
        long end_1 = System.nanoTime();

        long start_2 = System.nanoTime();
        String reversed_2 = reverseString2(nome);
        long end_2 = System.nanoTime();

        long start_3 = System.nanoTime();
        String reversed_3 = reverseString3(nome);
        long end_3 = System.nanoTime();

        long start_4 = System.nanoTime();
        String reversed_4 = reverseString5(nome);
        long end_4 = System.nanoTime();

        long start_5 = System.nanoTime();
        String reversed_5 = reverseString(gigante);
        long end_5 = System.nanoTime();

        long start_6 = System.nanoTime();
        String reversed_6 = reverseString2(gigante);
        long end_6 = System.nanoTime();

        long start_7 = System.nanoTime();
        String reversed_7 = reverseString3(gigante);
        long end_7 = System.nanoTime();

        long start_8 = System.nanoTime();
        String reversed_8 = reverseString5(gigante);
        long end_8 = System.nanoTime();

        System.out.println("Time: " + (end_1 - start_1) + " ns");
        System.out.println("Time: " + (end_2 - start_2) + " ns");
        System.out.println("Time: " + (end_3 - start_3) + " ns");
        System.out.println("Time: " + (end_4 - start_4) + " ns");
        System.out.println();
        System.out.println("Time: " + (end_5 - start_5) + " ns");
        System.out.println("Time: " + (end_6 - start_6) + " ns");
        System.out.println("Time: " + (end_7 - start_7) + " ns");
        System.out.println("Time: " + (end_8 - start_8) + " ns");
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


    public static String reverseString2(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }
        return reversed;
    }

    public static String reverseString3(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseString5(String str) {
        return new String(new StringBuilder(str).reverse());
    }

    public static String reverseString4(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }
}
