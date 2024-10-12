public class _204_CountPrimes {
    public static void main(String[] args) {
        testCountPrimes(10);
        testCountPrimes(0);
        testCountPrimes(1);
        testCountPrimes(2);
        testCountPrimes(3);
        testCountPrimes(4);
        testCountPrimes(5);
        testCountPrimes(6);
        testCountPrimes(7);
        testCountPrimes(8);
        testCountPrimes(999999999);
    }

    public static int countPrimes(int n) {
        if (n <= 1) return 0;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) count++;
        }
        return count;
    }


    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }


    public static void testCountPrimes(int n) {
        long startTime = System.nanoTime();
        int answer = countPrimes(n);
        long endTime = System.nanoTime();
        System.out.println("\nInput: n = " + n);
        System.out.println("Answer: " + answer);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
    }
}
