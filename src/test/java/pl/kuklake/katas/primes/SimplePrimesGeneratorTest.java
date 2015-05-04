package pl.kuklake.katas.primes;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimplePrimesGeneratorTest {
	
	private PrimesGenerator generator;
	
	@Before
	public void mockPrimesGenerator(){
		this.generator = new SimplePrimesGenerator();
	}
	
	@Test
	public void shouldGenerate2ForMaxPrimes2(){
		int max = 2;
		int[] primes = generator.generate(max);
		assertEquals(2, primes[0]);		
		assertEquals(0, primes[1]);
	}
	
	@Test
	public void shouldGenerate2and3ForMaxPrimes4(){
		int max = 4;
		int[] primes = generator.generate(max);
		assertEquals(2, primes[0]);
		assertEquals(3, primes[1]);
		assertEquals(0, primes[2]);
	}
	
	@Test
	public void shouldGenerate4PrimesForMaxPrimes10(){
		int max = 10;
		int[] primes = generator.generate(max);
		
		int size = 0;
		for(int prime : primes){
			if(prime != 0){
				size++;
			} else {
				break;
			}
		}
		
		assertEquals(4, size);
	}

}
