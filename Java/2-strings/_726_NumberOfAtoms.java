import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _726_NumberOfAtoms {

    /*
    726. number of Atoms
    Given a string formula representing a chemical formula,
    return the count of each atom.

    the atomic element always starts with an uppercase character,
    then zero or more lowercase letters, representing the name.

    one or more digits representing that element's count may follow if the count is greater than 1.
    if the count is 1, no digits will follow.

    for example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
    two formulas are concatenated together to produce another formula.

    for example, "H2O2He3Mg4" is also a formula.
    a formula placed in parentheses, and a count (optionally added) is also a formula.

    for example, "(H2O2)" and "(H2O2)3" are formulas.
    Return the count of all elements as a string in the following form: the first name (in sorted order),
    followed by its count (if that count is more than 1), followed by the second name (in sorted order),
    followed by its count (if that count is more than 1), and so on.

    the test cases are generated so that all the values in the output fit in a 32-bit integer.

    Example 1:
    Input: formula = "H2O"
    Output: "H2O"
    Explanation: The count of elements are {'H': 2, 'O': 1}.

    Example 2:
    Input: formula = "Mg(OH)2"
    Output: "H2MgO2"
    Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.

    Example 3:
    Input: formula = "K4(ON(SO3)2)2"
    Output: "K4N2O14S4"
    Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.

    Constraints:
    1 <= formula.length <= 1000.
    formula consists of English letters, digits, '(', and ')'.
    formula is always valid.
     */

    public static void main(String[] args) {

        String formula1 = "H2O";
        String formula2 = "Mg(OH)2";
        String formula3 = "K4(ON(SO3)2)2";
        String formula4 = "H2O2";
        String formula5 = "H2O2He3Mg4";
        String formula6 = "(H2O2)";
        String formula7 = "(H2O2)3";

        testCountOfAtoms(formula1);
        testCountOfAtoms(formula2);
        testCountOfAtoms(formula3);
        testCountOfAtoms(formula4);
        testCountOfAtoms(formula5);
        testCountOfAtoms(formula6);
        testCountOfAtoms(formula7);
    }

    private static final Map<String, Integer> elementos = new HashMap<>();

    static {
        elementos.put("H", 1);
        elementos.put("He", 2);
        elementos.put("Li", 3);
        elementos.put("Be", 4);
        elementos.put("B", 5);
        elementos.put("C", 6);
        elementos.put("N", 7);
        elementos.put("O", 8);
        elementos.put("F", 9);
        elementos.put("Ne", 10);
        elementos.put("Na", 11);
        elementos.put("Mg", 12);
        elementos.put("Al", 13);
        elementos.put("Si", 14);
        elementos.put("P", 15);
        elementos.put("S", 16);
        elementos.put("Cl", 17);
        elementos.put("Ar", 18);
        elementos.put("K", 19);
        elementos.put("Ca", 20);
        elementos.put("Sc", 21);
        elementos.put("Ti", 22);
        elementos.put("V", 23);
        elementos.put("Cr", 24);
        elementos.put("Mn", 25);
        elementos.put("Fe", 26);
        elementos.put("Co", 27);
        elementos.put("Ni", 28);
        elementos.put("Cu", 29);
        elementos.put("Zn", 30);
        elementos.put("Ga", 31);
        elementos.put("Ge", 32);
        elementos.put("As", 33);
        elementos.put("Se", 34);
        elementos.put("Br", 35);
        elementos.put("Kr", 36);
        elementos.put("Rb", 37);
        elementos.put("Sr", 38);
        elementos.put("Y", 39);
        elementos.put("Zr", 40);
        elementos.put("Nb", 41);
        elementos.put("Mo", 42);
        elementos.put("Tc", 43);
        elementos.put("Ru", 44);
        elementos.put("Rh", 45);
        elementos.put("Pd", 46);
        elementos.put("Ag", 47);
        elementos.put("Cd", 48);
        elementos.put("In", 49);
        elementos.put("Sn", 50);
        elementos.put("Sb", 51);
        elementos.put("Te", 52);
        elementos.put("I", 53);
        elementos.put("Xe", 54);
        elementos.put("Cs", 55);
        elementos.put("Ba", 56);
        elementos.put("La", 57);
        elementos.put("Ce", 58);
        elementos.put("Pr", 59);
        elementos.put("Nd", 60);
        elementos.put("Pm", 61);
        elementos.put("Sm", 62);
        elementos.put("Eu", 63);
        elementos.put("Gd", 64);
        elementos.put("Tb", 65);
        elementos.put("Dy", 66);
        elementos.put("Ho", 67);
        elementos.put("Er", 68);
        elementos.put("Tm", 69);
        elementos.put("Yb", 70);
        elementos.put("Lu", 71);
        elementos.put("Hf", 72);
        elementos.put("Ta", 73);
        elementos.put("W", 74);
        elementos.put("Re", 75);
        elementos.put("Os", 76);
        elementos.put("Ir", 77);
        elementos.put("Pt", 78);
        elementos.put("Au", 79);
        elementos.put("Hg", 80);
        elementos.put("Tl", 81);
        elementos.put("Pb", 82);
        elementos.put("Bi", 83);
        elementos.put("Po", 84);
        elementos.put("At", 85);
        elementos.put("Rn", 86);
        elementos.put("Fr", 87);
        elementos.put("Ra", 88);
        elementos.put("Ac", 89);
        elementos.put("Th", 90);
        elementos.put("Pa", 91);
        elementos.put("U", 92);
        elementos.put("Np", 93);
        elementos.put("Pu", 94);
        elementos.put("Am", 95);
        elementos.put("Cm", 96);
        elementos.put("Bk", 97);
        elementos.put("Cf", 98);
        elementos.put("Es", 99);
        elementos.put("Fm", 100);
        elementos.put("Md", 101);
        elementos.put("No", 102);
        elementos.put("Lr", 103);
        elementos.put("Rf", 104);
        elementos.put("Db", 105);
        elementos.put("Sg", 106);
        elementos.put("Bh", 107);
        elementos.put("Hs", 108);
        elementos.put("Mt", 109);
        elementos.put("Ds", 110);
        elementos.put("Rg", 111);
        elementos.put("Cn", 112);
        elementos.put("Nh", 113);
        elementos.put("Fl", 114);
        elementos.put("Mc", 115);
        elementos.put("Lv", 116);
        elementos.put("Ts", 117);
        elementos.put("Og", 118);
    }

    public static int countOfAtoms(String formula) {
        int i = 0, n = formula.length(); // Inicializando índices para percorrer a fórmula

        Stack<Map<String, Integer>> stack = new Stack<>(); // Pilha para armazenar contagens de elementos
        stack.push(new HashMap<>()); // Inicializando a pilha com um mapa vazio

        while (i < n) { // Loop para percorrer a fórmula
            if (formula.charAt(i) == '(') { // Encontrado um parêntese de abertura
                stack.push(new HashMap<>()); // Novo mapa para o grupo dentro dos parênteses
                i++;
            } else if (formula.charAt(i) == ')') { // Encontrado um parêntese de fechamento
                Map<String, Integer> top = stack.pop(); // Obtém o mapa do grupo atual
                int iStart = ++i, multiplicity = 1; // Índice de início para o multiplicador e valor padrão
                while (i < n && Character.isDigit(formula.charAt(i))) i++; // Encontra o multiplicador
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i)); // Analisa o multiplicador
                for (String c : top.keySet()) { // Loop pelos elementos no grupo
                    int v = top.get(c); // Obtém a contagem do elemento
                    stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity); // Atualiza a contagem no mapa anterior
                }
            } else { // Encontrado um elemento
                int iStart = i++; // Índice de início do nome do elemento
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++; // Encontra o nome completo do elemento
                String name = formula.substring(iStart, i);
                iStart = i; // Índice de início para o multiplicador
                while (i < n && Character.isDigit(formula.charAt(i))) i++; // Encontra o multiplicador
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1; // Analisa o multiplicador
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity); // Atualiza a contagem do elemento
            }
        }

        Map<String, Integer> map = stack.pop(); // Obtém o mapa final com as contagens
        int res = 0; // Inicializa o resultado
        for (String c : map.keySet()) { // Loop pelos elementos no mapa
            res += elementos.get(c) * map.get(c); // Calcula o número atômico total
        }
        return res;
    }

    public static void testCountOfAtoms(String formula) {

        System.out.println("Input: formula = \"" + formula + "\"");

        long start = System.nanoTime();
        int result = countOfAtoms(formula);
        long end = System.nanoTime();

        System.out.println("Output: \"" + result + "\"");
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
