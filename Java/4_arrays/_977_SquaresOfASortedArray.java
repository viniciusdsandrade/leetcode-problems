import java.util.Arrays;

public class _977_SquaresOfASortedArray {

    /*
    977. Squares of a Sorted Array

    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:
    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

    Example 2:
    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

    Constraints:
    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in non-decreasing order.

    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
     */

    public static void main(String[] args) {
        int[] numeros1 = {-4, -1, 0, 3, 10};
        testarQuadradosOrdenados(numeros1);

        int[] numeros2 = {-7, -3, 2, 3, 11};
        testarQuadradosOrdenados(numeros2);
    }

    public static int[] sortedSquares(int[] nums) {
        int tam = nums.length;
        int[] res = new int[tam];

        // Ponteiros para o início (esquerda) e fim (direita) do array
        int esq = 0, dir = tam - 1;

        // Posição para inserir o próximo maior valor de quadrado no array de res
        int pos = tam - 1;

        // Loop até que os ponteiros se encontrem
        while (esq <= dir) {
            // Calcula o quadrado do valor da esquerda e da direita
            int quadradoEsquerda = nums[esq] * nums[esq];
            int quadradoDireita = nums[dir] * nums[dir];

            // Compara os quadrados e insere o maior na posição correta no array de res
            if (quadradoEsquerda > quadradoDireita) {
                res[pos] = quadradoEsquerda;
                esq++; // Move o ponteiro da esquerda para a direita
            } else {
                res[pos] = quadradoDireita;
                dir--; // Move o ponteiro da direita para a esquerda
            }

            // Move para a próxima posição do array de res
            pos--;
        }

        // Retorna o array de quadrados ordenados
        return res;
    }

    public static void testarQuadradosOrdenados(int[] numeros) {
        System.out.println("Entrada: numeros = " + Arrays.toString(numeros));

        int[] resultado;
        long inicio, fim, tempoExecucao;

        inicio = System.nanoTime();
        resultado = sortedSquares(numeros);
        fim = System.nanoTime();

        tempoExecucao = fim - inicio;

        System.out.println("Saída: " + Arrays.toString(resultado));
        System.out.println("Tempo de Execução: " + tempoExecucao + "ns\n");
    }
}
