/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 1000; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String upperStr1 = str1.toUpperCase();
		String upperStr2 = str2.toUpperCase();

		String charChecked = "";
		for (int i = 0; i < upperStr1.length(); i++) {
			char currChar = upperStr1.charAt(i);
			if (charChecked.indexOf(currChar) != -1 || currChar == ' ') {continue;}
			charChecked += currChar;

			int countChar1 = 0;
			int currIndex1 = upperStr1.indexOf(currChar); 
			while (currIndex1 != -1) {
				countChar1++;
				currIndex1 = upperStr1.indexOf(currChar, currIndex1 + 1);
			}

			int countChar2 = 0;
			int currIndex2 = upperStr2.indexOf(currChar); 
			while (currIndex2 != -1) {
				countChar2++;
				currIndex2 = upperStr2.indexOf(currChar, currIndex2 + 1);
			}


			if (countChar1 != countChar2) {return false;}
		}
		// Replace the following statement with your code
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String cutStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i)) && !Character.isWhitespace(str.charAt(i))) {continue;}
			cutStr += str.charAt(i);
		}
		return cutStr.toLowerCase();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String randStr = "";
		String copyStr = str;
		while (!copyStr.isEmpty()){
			int i = (int) (Math.random() * copyStr.length());
			char chosenChar = copyStr.charAt(i);
			randStr += chosenChar;
			copyStr = copyStr.substring(0, i) + copyStr.substring(i + 1);
		}
		return randStr;
	}
}
