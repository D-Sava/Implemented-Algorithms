public class SieveOfEratosthens {

    public static boolean[] getPrimes(int n){

        boolean[] primes = new boolean[n+1];

        for(int i = 2; i < primes.length; i++){
            primes[i] = true;
        }

        for(int p = 2; p*p < n; p++){

            if(primes[p] == true){

                for(int i = p*p; i <= n; i+=p){
                    primes[i] = false;
                }

            }
        }

        return primes;

    }

    public static void printPrimes(boolean[] primes){

       for(int i = 0; i < primes.length; i++){

           if(primes[i] == true)
               System.out.println(i);

       }
    }
}
