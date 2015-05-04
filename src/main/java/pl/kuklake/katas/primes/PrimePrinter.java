package pl.kuklake.katas.primes;

import java.util.Arrays;

public class PrimePrinter {
	
	private static final int MAX_PRIME = 13;
	
	public static void main(String[] args) {
		PrimesGenerator primesGenerator = PrimesGeneratorFactory.getInstance();
		
		int[] primes = primesGenerator.generate(MAX_PRIME);
		System.out.println(Arrays.toString(primes));
		
		int size = 0;
		for(int prime : primes){
			if(prime != 0){
				size ++;
			}
		}
		System.out.println("ilosc liczb pierwszych: " + size);
		System.out.println("rozmiar tablicy: " + primes.length);
	}
	

}
