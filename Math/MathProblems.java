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

    public boolean isPrime(int n) {
        if (n != 2 && n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSuperPrime(int n) {
        if (n < 10) {
            return isPrime(n);
        }
        if (isPrime(n)) {
            return isSuperPrime(n / 10);
        }
        return false;
    }
}
