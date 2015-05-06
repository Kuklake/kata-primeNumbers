package pl.kuklake.katas.primes;


public class SieveOfEratosthenes implements PrimesGenerator {
	
	private boolean[] numbers;
	private int[] primes;
	private int candidate = 2;

	@Override
	public int[] generate(int maxPrime) {
		this.numbers = new boolean[maxPrime +1];
		
		initializeWithTrue();
		
		while(candidate < maxPrime){
			setCandidateMultiplesToFalse();
			findNextCandidate();
		}
		
		initiallizePrimesArray();
		
		return primes;
	}
	
	private void initializeWithTrue() {
		for(int i = 2 ; i < numbers.length; i++) {
			numbers[i] = true;
		}		
	}
	
	private void findNextCandidate() {
		while(++candidate < numbers.length && numbers[candidate] == false){
			candidate++;
		}
	}

	private void setCandidateMultiplesToFalse() {
		for(int i = 2*candidate; i < numbers.length; i += candidate){
			numbers[i] = false;
		}
	}
	
	private void initiallizePrimesArray() {
		primes = new int[countPrimes()];
		int primeIndex = 0;
		for(int i = 2; i < numbers.length; i++){
			if(numbers[i]){
				primes[primeIndex] = i;
				primeIndex++;
			}
		}
	}

	private int countPrimes() {
		int count = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i]) {
				count++;
			}
		}
		return count;
	}
}
