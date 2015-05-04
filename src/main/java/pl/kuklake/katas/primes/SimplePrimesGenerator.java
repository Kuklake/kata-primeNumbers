package pl.kuklake.katas.primes;

public class SimplePrimesGenerator implements PrimesGenerator {

	private static final int FIRST_PRIME_NUMBER = 2;

	private int[] primes;
	private int candidate = FIRST_PRIME_NUMBER;
	private int primeIndex = 0;

	@Override
	public int[] generate(int maxPrime) {
		int numberOfPrimes = estimateNumberOfPrimes(maxPrime);
		primes = new int[numberOfPrimes];
		primes[primeIndex++] = candidate;

		while (candidate < maxPrime) {
			candidate++;

			if (candidateApproved() && candidateNotYetAdded()) {
				primes[primeIndex++] = candidate;
			}
		}
		
		return primes;
	}

	private int estimateNumberOfPrimes(int maxPrime) {
		int a;
		if (maxPrime < 8) {
			return maxPrime;
		} else if (maxPrime < 1000) {
			a = 1;
		} else {
			a = 2;
		}

		Double doubleN = (maxPrime / (Math.log(maxPrime) - a));
		return doubleN.intValue();

	}

	private boolean candidateApproved() {
		for (int prime : primes) {
			if (prime != 0 && candidate % prime == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean candidateNotYetAdded() {
		for (int prime : primes) {
			if (prime == candidate) {
				return false;
			}
		}
		return true;
	}

}
