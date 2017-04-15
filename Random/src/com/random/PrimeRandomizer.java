package com.random;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeRandomizer implements Runnable {

	//private final BlockingQueue<Values> sharedQueue;
	private BlockingQueue<Values> sharedQueue = new ArrayBlockingQueue<Values>(1);
	public PrimeRandomizer(BlockingQueue<Values> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				int k = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
				Thread.sleep(1000);
				System.out.println("Calculating prime: " + k);
				
				Values v = new Values(k, false, false);
				caluclatePrime(v);
				sharedQueue.put(v);

			} catch (InterruptedException ex) {
				Logger.getLogger(PrimeRandomizer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private void caluclatePrime(Values val) {
		int i, m = 0, flag = 0;
		int n = val.getVal();
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i == 0) {
				flag = 1;
				break;
			}
		}
		val.setCaluclated(true);
		if (flag == 0)
			val.setPrime(true);

	}

}
