public class StringModifier {

	public static String scrambleString(String input) {
		String output = "";
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if ((i % 2) == 1) {
				output = charArray[i] + output;
			} else {
				output = output + charArray[i];
			}
		}

		return output;
	}

	public static String descrambleString(String input) {
		String output = "";
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			if ((i % 2) == 1) {
				output = output + charArray[i];
			} else {
				output = charArray[i] + output;
			}
		}

		return output;
	}

	/*
	 * Methods
	 * #############################################################################
	 * #
	 */


}
