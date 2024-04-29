import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _420_StrongPasswordChecker {

    /*
    420. Strong Password Checker
    A password is considered strong if the below conditions are all met:

    It has at least 6 characters and at most 20 characters.
    It contains at least one lowercase letter, at least one uppercase letter, and at least one digit.
    It does not contain three repeating characters in a row (i.e., "Baaabb0" is weak, but "Baaba0" is strong).
    Given a string password, return the minimum number of steps required to make password strong.
    If the password is already strong, return 0.

    In one step, you can:

    Insert one character to password,
    Delete one character from password, or
    Replace one character of password with another character.

    Example 1:
    Input: password = "a"
    Output: 5

    Example 2:
    Input: password = "aA1"
    Output: 3

    Example 3:
    Input: password = "1337C0d3"
    Output: 0

    Constraints:
    1 <= password.length <= 50
    passwords consist of letters, digits, dot '.'
    Or exclamation mark '!'.
     */

    public static int strongPasswordChecker(String password) {
        int n = password.length();
        int lower = 1, upper = 1, digit = 1;
        int replacements = 0, missingType = 0;

        // Check for missing character types and repeating characters
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) lower = 0;
            else if (Character.isUpperCase(c)) upper = 0;
            else if (Character.isDigit(c)) digit = 0;

            if (i > 1 && password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                if (i < n - 2 && password.charAt(i) != password.charAt(i + 1)) {
                    // Replace with missing type if possible and beneficial
                    if (lower == 1) {
                        lower = 0;
                    } else if (upper == 1) {
                        upper = 0;
                    } else if (digit == 1) {
                        digit = 0;
                    } else {
                        replacements++; // Otherwise, count as a regular replacement
                    }
                } else {
                    replacements++;
                }
                i += 2; // Skip the next two characters
            }
        }
        missingType = lower + upper + digit;

        // Handle length violations
        if (n < 6) {
            return Math.max(6 - n, missingType);
        } else if (n <= 20) {
            return Math.max(replacements, missingType);
        } else { // n > 20
            int deletesNeeded = n - 20;

            // Prioritize deleting repeating characters
            replacements -= Math.min(deletesNeeded, replacements);

            // Handle remaining length issues and missing types
            return deletesNeeded + Math.max(replacements, missingType);
        }
    }

    public static boolean strongPasswordChecker2(String password) {
        return checkIfStringContainsSixToTwentyCharacters(password) &&
                checkIfStringContainsTwoLowerCaseLetters(password) &&
                checkIfStringContainsTwoUpperCaseLetters(password) &&
                checkIfStringContainsAtLeastOneDigit(password) &&
                checkIfStringContainsOneToTenSpecialCharacters(password) &&
                checkIfStringContainsThreeOrMoreDigitsInSequence(password) &&
                checkIfStringContainsThreeOrMoreIgnoreCaseLettersInSequence(password);
    }

    public static boolean checkIfStringContainsTwoLowerCaseLetters(String password) {
        return password.matches(".*[a-z].*[a-z].*");
    }

    public static boolean checkIfStringContainsTwoUpperCaseLetters(String password) {
        return password.matches(".*[A-Z].*[A-Z].*");
    }

    public static boolean checkIfStringContainsAtLeastOneDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean checkIfStringContainsSpecialCharacters(String password) {
        Pattern specialChars = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
        return specialChars.matcher(password).find();
    }

    public static boolean checkIfStringContainsOneToTenSpecialCharacters(String password) {
        Pattern specialChars = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]");
        int specialCharCount = 0;

        for (int i = 0; i < password.length(); i++) {
            if (specialChars.matcher(String.valueOf(password.charAt(i))).matches())
                specialCharCount++;
        }

        return specialCharCount >= 1 && specialCharCount <= 10;
    }

    public static boolean checkIfStringContainsSixToTwentyCharacters(String password) {
        return password.length() >= 6 && password.length() <= 20;
    }

    public static boolean checkIfStringContainsThreeOrMoreDigitsInSequence(String password) {
        // Define o padrão regex para sequências numéricas crescentes ou decrescentes de 4 dígitos
        String padrao = "(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3}\\d";

        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(password);

        return !matcher.find();
    }

    public static boolean checkIfStringContainsThreeOrMoreIgnoreCaseLettersInSequence(String password) {
        // Sequências precisam ter pelo menos 4 letras
        if (password.length() < 4) return true;

        // Ignorar maiúsculas e minúsculas
        password = password.toLowerCase();

        // Verificar se a sequência é ascendente ou descendente
        boolean ascendente = true;
        boolean descendente = true;

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) <= password.charAt(i - 1)) ascendente = false;
            if (password.charAt(i) >= password.charAt(i - 1)) descendente = false;
        }

        return !ascendente && !descendente;
    }

    public static void main(String[] args) {

        testStrongPasswordChecker2("a");
        testStrongPasswordChecker2("aA1");
        testStrongPasswordChecker2("1337C0d3");

        // Senhas válidas
        testStrongPasswordChecker("GhostSthong534231@#");
        testStrongPasswordChecker("GhostSthong3246@#");
        testStrongPasswordChecker("GhostSthong5000@#");
        testStrongPasswordChecker("SenhaForte111aa!");
        testStrongPasswordChecker("T3st3_D3_S3nh@");
        testStrongPasswordChecker("S3nh@C0mPl3x@");
        testStrongPasswordChecker("S3nh@F0rt3_123");

        // Senhas inválidas
        testStrongPasswordChecker("senhafraca");     // Sem maiúsculas, dígitos ou caracteres especiais
        testStrongPasswordChecker("SENHA FORTE");    // Sem minúsculas ou caracteres especiais
        testStrongPasswordChecker("12345678");       // Apenas dígitos
        testStrongPasswordChecker("Senha123");      // Sem caracteres especiais
        testStrongPasswordChecker("Senhaaaa1!");    // Caracteres repetidos
        testStrongPasswordChecker("senha");          // Comprimento insuficiente
        testStrongPasswordChecker("SenhaMuitoLonga1234567!"); // Comprimento excessivo
        testStrongPasswordChecker("Senha!@#");       // Apenas um tipo de caractere especial
        testStrongPasswordChecker("Senha1!@#");      // Apenas um dígito
        testStrongPasswordChecker("sEnHa1!");         // Apenas uma letra maiúscula
        testStrongPasswordChecker("SENHA1!");        // Apenas uma letra minúscula
        testStrongPasswordChecker("S3nh@1!@#$$$$$$$"); // Muitos caracteres especiais
        testStrongPasswordChecker("S3nh@1111!");    // Dígitos repetidos
        testStrongPasswordChecker("S3nh@aaa!");      // Letras minúsculas repetidas
    }

    public static void testStrongPasswordChecker(String password) {
        System.out.println("\nInput: password = \"" + password + "\"");
        long start2 = System.nanoTime();
        boolean output2 = strongPasswordChecker2(password);
        long end2 = System.nanoTime();

        System.out.println("Output: " + output2);
        System.out.println("Execution time: " + (end2 - start2) + " ns");
    }

    public static void testStrongPasswordChecker2(String password) {
        System.out.println("\nInput: password = \"" + password + "\"");
        long start = System.nanoTime();
        int output = strongPasswordChecker(password);
        long end = System.nanoTime();

        System.out.println("Output: " + output);
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}
