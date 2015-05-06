package pl.kuklake.katas.primes;

public class PrimesGeneratorFactory {
	
	public static PrimesGenerator getInstance() {
		return new SieveOfEratosthenes();
	}

}
