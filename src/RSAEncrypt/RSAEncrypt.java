package RSAEncrypt;

import java.math.BigInteger;
import java.util.Random;

/**
 * RSAEncrypt class implements the RSA encryption algorithm
 * 
 * Due Date: 04/24/2019
 * 
 * @author Lannie Dalton Hough III
 * @version 1.0
 */

public class RSAEncrypt {
    private BigInteger myP;
    private BigInteger myQ;
    private BigInteger myN; //modulus
    private BigInteger myPhi;
    private BigInteger myE = new BigInteger("65537"); //encryption exponent, public - Fermat prime
    private BigInteger myD; //decryption exponent, secret
    private Random myRandom;

    /**
	 * Constructor method initializes necessary variables in RSA encryption
	 */
    
    RSAEncrypt() {
        myRandom = new Random();
        myP = BigInteger.probablePrime(2048, myRandom); //4096 bit size
        myQ = BigInteger.probablePrime(2048, myRandom);
        myN = myP.multiply(myQ);
        myPhi = myP.subtract(BigInteger.ONE).multiply(myQ.subtract(BigInteger.ONE));
        myD = myE.modInverse(myPhi);
    }
    
  //Main method for testing algorithm
    /*
    public static void main(String[] RSAEncrypts) {
    	RSAEncrypt rsa = new RSAEncrypt();
    	String s = "My name is Dalton";
		System.out.println(s);
		System.out.println("String in ASCII: " + rsa.returnToString(s.getBytes()));
    	byte[] encrypted = rsa.Encrypt(s);
    	byte[] decrypted = rsa.Decrypt(encrypted);
    	System.out.println(new String(decrypted));
    }*/

 
    /**
	 * Method turns ASCII formatted data into a string readable by a human
	 * 
	 * @return String representation of data to show ASCII formatted text
	 */
    
    public String returnToString(byte[] encrypted) {
        String s = "";
        for (byte b : encrypted) {
            s = s + Byte.toString(b);
        }
        return s;
    }
    
    /**
	 * Method uses the RSA encryption algorithm to encrypt the ASCII formatted data
	 * 
	 * @return byte array of encrypted data
	 */
    
    public byte[] Encrypt(String message) {
    	byte[] byteMessage = message.getBytes();
    	byte[] byteMessageEncrypted;
        byteMessageEncrypted = (new BigInteger(byteMessage)).modPow(myE, myN).toByteArray(); //public key
        return byteMessageEncrypted;
    }

    /**
	 * Method decrypts the encrypted data and converts it to a human readable string
	 * 
	 * @return String representation of now decrypted data
	 */
    
    public String Decrypt(byte[] message) {
    	String s;
    	byte[] b = (new BigInteger(message)).modPow(myD, myN).toByteArray(); //private key
    	s = new String(b);
        return s;
    }

}
