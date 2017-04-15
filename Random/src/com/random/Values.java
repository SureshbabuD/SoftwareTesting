package com.random;

public class Values {
	private int val;
	private boolean isPrime;
	private boolean isCaluclated;

	public boolean isCaluclated() {
		return isCaluclated;
	}

	public void setCaluclated(boolean isCaluclated) {
		this.isCaluclated = isCaluclated;
	}
	
	public Values(){
		
	}
	public Values(int val, boolean isCaluclated, boolean isPrime) {
		this.val = val;
		this.isCaluclated = isCaluclated;
		this.isPrime = isPrime;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}
}
