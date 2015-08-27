public class MathProblems {
    public void printPrimeNumbers (int n) {
        /*
        print the prime numbers under positive number: n
        */
        if (n < 2) {
            System.out.println("No prime number exists");
        }
        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                System.out.print("\t" + i);
            }
        }
    }
}
