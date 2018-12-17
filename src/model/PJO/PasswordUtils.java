package model.PJO;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {
	
	private static final Random RANDOM= new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

	public static String getSalt(int lenght) {
		
		StringBuilder builder = new StringBuilder(lenght);
		for(int i=0;i<lenght;i++) {
			builder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		
		return new String(builder);
		
	}
	
	public static byte[] hash(char[] password,byte[] salt) {
		
		PBEKeySpec spec = new PBEKeySpec(password,salt,ITERATIONS,KEY_LENGTH);
		
		Arrays.fill(password, Character.MIN_VALUE); // assegna ad ogni cella dell'array password il valore '\u0000'
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); //otteniamo istanza dell'algoritmo
			return skf.generateSecret(spec).getEncoded();						//che fa uso della crittografia 'SHA1'
		}																	//otteniamo infine la sequenza di byte criptata
		catch(NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		}
		finally {
			spec.clearPassword();
		}
		
	}
	
	public static String generateSecurePassword(String password, String salt) {
		
		String returnValue = null;
		
		byte[] securePassword = hash(password.toCharArray(),salt.getBytes());
		
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		
		return returnValue;
		
	}
	
	public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
	
		boolean returnValue = false;
		
		String newSecurePassword = generateSecurePassword(providedPassword,salt);
		
		returnValue = newSecurePassword.equals(securedPassword);
		
		return returnValue;
	}
}