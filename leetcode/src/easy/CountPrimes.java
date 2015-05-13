package easy;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
	public int countPrimes(int n) {
		int res = 0;
		boolean[] isMarked = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (!isMarked[i]) {
				res++;
				for (int j = i + i; j < n; j += i) {
					isMarked[j] = true;
				}
			}
		}
		return res;
	}
	/**
	 * 排除所有之前素数的倍数，剩下的一定是素数
	 * @param n
	 * @return
	 */
	public int countPrimes1(int n) {
		boolean[] primes = new boolean[n];
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (!primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = true;
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!primes[i]) {
				count++;
			}
		}
		return count;
	}
	
	
	List<Integer> prime = new ArrayList<>();
	/**
	 * 一个数是否为素数只需要看能否被比其小的素数整除即可
	 * @param n
	 * @return
	 */
    public int countPrimes2(int n) {
        int res = 0;
        for(int i=2;i<n;i++){
        	if(isPrime(i)) res++;
        }
        return res;
    }
    
    private boolean isPrime(int n){
    	int m = (int) Math.sqrt(n);
    	if(n==1) return false;
    	for(int itt:prime){
    		if(itt>m) break;
    		if(n%itt==0) return false;
    	}
    	prime.add(n);
    	return true;
    }
	public static void main(String[] args) {
		System.out.println(new CountPrimes().countPrimes1(1500000));
	}
}
