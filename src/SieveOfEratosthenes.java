// Java program to print all primes smaller than or equal to n using Sieve of Eratosthenes
class SieveOfEratosthenes {

    public static int[] prime;

    public static void sieveProcess(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize all entries it as true. A value in
        // prime[i] will finally be false if i is Not a prime, else true.
        prime = new int[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = 1;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == 1) {
                // Update all multiples of p greater than or equal to the square of it numbers which
                // are multiple of p and are less than p^2 are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = 0;
            }
        }
    }

    // Print all prime numbers
    public static void printPrimes() {
        for (int i = 2; i < prime.length; i++) {
            if (prime[i] == 1)
                System.out.print(i + " ");
        }
    }

    public static void main(String args[])
    {
        int n = 1000;
        System.out.println("Following are the prime numbers smaller than or equal to " + n);
        long start = System.nanoTime();
//        System.out.println("start = " + start);
        SieveOfEratosthenes.sieveProcess(n);
//        long end = System.nanoTime();
//        System.out.println("end = " + end);
        System.out.printf("Czas programu = %d ns \n", System.nanoTime() - start);
        SieveOfEratosthenes.printPrimes();
    }
}
