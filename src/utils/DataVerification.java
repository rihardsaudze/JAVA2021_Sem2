package utils;

public class DataVerification {

	public static String nameAndSurnameVerification(String input) {
		String result = "";
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isLetter(input.charAt(i)) || Character.isSpaceChar(input.charAt(i)) || input.charAt(i) == 45) {
				result += input.charAt(i);
			}
		}
		
		return result;
	}
	
	public static boolean isLetter(String input) {
		//if (input.matches("[A-Z]{1}[a-z]+$")) {
		//	return true;
		//} else {
		//	return false;
		//}
		return (input.matches("[A-Z]{1}[a-z]+$"));
	}
}
