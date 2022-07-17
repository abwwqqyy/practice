package QW;

public class LC204CountPrimes {
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        if(n <= 1) return 0;
        for(int i = 2; i * i < n; i++){
            if(notPrime[i]) continue;
            for(int j = 2; j * i < n; j++){ //will cover all non-prime numbers < n
                notPrime[j * i] = true;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]) count++;
        }
        // System.out.println(Arrays.toString(notPrime));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(31));//10
    }
}
// time O(n + sqrt(n)log(logn)) space O(n)
