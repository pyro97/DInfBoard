package model.PJO;

public class Main {

	public static void main(String[] args) {

		/*
		String password = "provaPassword";
		String salt = PasswordUtils.getSalt(10);
		
		String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
		
		System.out.println(" password generata " + mySecurePassword);
		System.out.println(" Valore salt " + salt);
		*/
		
		String providedPassword = "provaPassword";
		
		String securePassword = "n01AmDNcMhP3aaTMAjxlDtHHUXHuL++c1rDTON/MSwo=";
		
		String salt = "1OX74xl4qw";
		
		boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
		
		if(passwordMatch) {
			System.out.println("Password combacia");
		}
		else {
			System.out.println("Password non combacia");
		}
	}

}
