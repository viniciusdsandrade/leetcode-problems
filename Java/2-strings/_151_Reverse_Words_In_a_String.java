public class _151_Reverse_Words_In_a_String {

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        testReverseWords(s1);

        String s2 = "  hello world  ";
        testReverseWords(s2);

        String s3 = "a good  example";
        testReverseWords(s3);
    }

    public static String reverseWords(String s) {
        if (s.isEmpty()) return "";
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty())
                sb.append(words[i]).append(" ");
        }
        return sb.isEmpty() ? "" : sb.substring(0, sb.length() - 1);
    }

    public static void testReverseWords(String s) {
        System.out.println("\nInput: " + s);

        long start = System.nanoTime();
        String result = reverseWords(s);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + "ns");
    }
}
