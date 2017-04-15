package com.random;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Randomizer implements Runnable {

	//private final BlockingQueue<Values> sharedQueue;
	private BlockingQueue<Values> sharedQueue = new ArrayBlockingQueue<Values>(1);

	public Randomizer(BlockingQueue<Values> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				
				Values v= (Values) sharedQueue.take();
				if (v.isPrime())
					System.out.println("Received from prime calculator : " + v.getVal()
							+ "  is prime number");
				else
					System.out.println("Received from prime calculator : " + v.getVal()
							+ "  is not a prime number");
			} catch (InterruptedException ex) {
				Logger.getLogger(Randomizer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
