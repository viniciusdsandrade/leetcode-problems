import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class _0_print_challenge {
    /*
     um loop que adicione 50 mil números sequenciais em um Array depois realize a soma de todos eles
     */
    public static void main(String[] args) {
        int ciclos = 10;
        int repeticoes = 10_000;
        Instant start;
        Instant end;
        int i, j;

        double[] averages = new double[ciclos]; // Array para armazenar as médias

        for (j = 0; j < ciclos; j++) { // Loop externo que executa 10 vezes
            long soma = 0; // Resetar a soma a cada ciclo externo
            for (i = 0; i < repeticoes; i++) { // Loop original
                start = Instant.now();
                printChallenge();
                end = Instant.now();
                soma += Duration.between(start, end).toNanos();
            }
            averages[j] = (double) soma / repeticoes; // Armazena a média no array
            System.out.printf("Média %d: %.4f ns\n", j + 1, averages[j]);
        }

        double mediaTotal = Arrays.stream(averages).average().orElse(0);
        System.out.printf("Média total: %.4f ms\n", mediaTotal / 1_000_000);
        System.out.printf("Média total: %f ns\n", mediaTotal);
    }

    // Versão com for
    public static void printChallenge() {
        int[] arr;
        arr = new int[50_000];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            sum += arr[i];
        }
    }
}
