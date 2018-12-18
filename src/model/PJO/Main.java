package model.PJO;

public class Main {

	public static void main(String[] args) {

		String password = "danieleCerardi";

		String salt = "1OX74xl4qw";
		
		String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
		
		System.out.println(" password generata " + mySecurePassword);
		System.out.println(" Valore salt " + salt);
		
		/*
		String providedPassword = "password1";
		
		String securePassword = "o06RPhUiImXXfZ13yMQ8zQ6Hsdr+lLa13IHB2PXZYts=";
		
		boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, "1OX74xl4qw");
		
		if(passwordMatch) {
			System.out.println("Password combacia");
		}
		else {
			System.out.println("Password non combacia");
		}
		*/
	}

}
