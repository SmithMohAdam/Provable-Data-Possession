package com.pdp.keyGen;

import java.math.BigInteger;
import java.security.SecureRandom;


public class Key {
	
	private BigInteger publickey; //Component
	private BigInteger privatekey;
	private static final BigInteger ONE = BigInteger.ONE;
	
	public Key(int numbits){
		//Generate p and q
		BigInteger p = BigInteger.probablePrime(numbits, new SecureRandom());
		BigInteger q = BigInteger.probablePrime(numbits, new SecureRandom());
		//Compute n - modulus
		BigInteger n = p.multiply(q);
		//Compute Euler's totient function, phiN
		BigInteger p_minus_one = p.subtract(ONE);
		BigInteger q_minus_one = q.subtract(ONE);
		BigInteger phiN = p_minus_one.multiply(q_minus_one);
		//Calculate public exponent
		BigInteger e, d;
		do {
			e = BigInteger.probablePrime(numbits, new SecureRandom());
		} while ((e.compareTo(ONE) == 1) && (e.compareTo(phiN) == -1) && (e.gcd(phiN).compareTo(ONE) != 0));
		//Calculate private exponent
		d = e.modInverse(phiN);
		//Set Keys
		
		publickey = e;
		privatekey = d;
		
//		publickey = new Key(e,n);
//		privatekey = new Key(d,n);
	}

	public BigInteger getPublickey() {
		return publickey;
	}

	public void setPublickey(BigInteger publickey) {
		this.publickey = publickey;
	}

	public BigInteger getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(BigInteger privatekey) {
		this.privatekey = privatekey;
	}
	
	

}
