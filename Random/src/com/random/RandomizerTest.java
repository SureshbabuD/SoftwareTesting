package com.random;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class RandomizerTest {

    public static void main(String args[]){
  
     BlockingQueue<Values> sharedQueue = new ArrayBlockingQueue<Values>(1);
 
     Thread primeRandomThread = new Thread(new PrimeRandomizer(sharedQueue));
     Thread randomThread = new Thread(new Randomizer(sharedQueue));

     primeRandomThread.start();
     randomThread.start();
    }
 
}


