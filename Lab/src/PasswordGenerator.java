
//import java.io.Console;
import java.util.Random;
import java.util.regex.Pattern;
import org.junit.Test;
public class PasswordGenerator {

	static Alice alice = new Alice();
	static String[][][] a = alice.book;
	private int Newline = 0;
	private int Single = 0;
	private int Equal = 0;
	private int length = 0;
	private int Upper = 0;
	private int Lower = 0;
	private int Special = 0;
	String password = "";

	//
	// constructor
	PasswordGenerator() {
		Newline = 0;
		Single = 0;
		Equal = 0;
		length = 0;
		Upper = 0;
		Lower = 0;
		Special = 0;
		password = "";
	}

//setters and getters
	int getNewline() {
		return Newline;
	}

	String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}

	void setNewline() {
		this.Newline++;
	}

	int getSingle() {
		return Single;
	}

	void setSingle() {
		this.Single++;
	}

	int getEqual() {
		return Equal;
	}

	void setEqual() {
		this.Equal++;
	}

	int getLength() {
		return length;
	}

	void setLength() {
		this.length++;
	}

	int getUpper() {
		return Upper;
	}

	void setUpper() {
		this.Upper++;
	}

	int getLower() {
		return Lower;
	}

	void setLower() {
		this.Lower++;
	}

	int getSpecial() {
		return Special;
	}

	void setSpecial() {
		this.Special++;
	}

	// methods
	// step2
	String choseLineRandomly(String[][][] a) {

		Random rand = new Random();
		int rndPage = rand.nextInt(a.length);
		int rndParagraph = rand.nextInt(a[rndPage].length);
		int rndLine = rand.nextInt(a[rndPage][rndParagraph].length);
		// System.out.println(rndPage + "/" + rndParagraph + "/" + rndLine);
		String result = "";
		result += a[rndPage][rndParagraph][rndLine].toString();
		// System.out.println(result);
		return result;
	}

	// step 3
	String[] splitTheLine(String line) {
		String[] stringArray = line.split(" ");
		return stringArray;
	}

	// step4
	String getRandomWord(String[] line) {
		Random rand = new Random();
		int index = rand.nextInt(line.length);
		// System.out.println("index of word is :" + index);
		return line[index].toString();
	}

	// step5 checkWordBACKUP- NOT USED
	String checkWordBACKUP(String randomWord) {
		if ((randomWord.length() == 1) || (randomWord.contains("\n")))
			while (true) {
				System.out.println("Do you want to continue? Y/N");
				// Get input here.
				if ((randomWord.length() != 1) || (!randomWord.contains("\n"))) {
					continue;
				} else {
					System.out.println("go back to Step 2.");
					// go back to Step 2.
					randomWord = getRandomWord(splitTheLine(choseLineRandomly(a)));
					break;
				}
			}
		System.out.println(randomWord);
		return randomWord;
	}

	// step5
	String checkWord(String randomWord) {
		//
		String checked = "";
		// String newline = System.getProperty("line.separator");
		boolean hasNewline = randomWord.contains("\n");
		//
		if ((randomWord.length() == 1) || (hasNewline)) {
			// System.out.println("(" + randomWord + ")");
			// go back to Step 2.
			if (randomWord.length() == 1) {
				// System.out.println("!!!! Single!!!!!!!!!!!!====>" + randomWord);
				setSingle();
			}
			if (hasNewline) {
				setNewline();
				// System.out.println("!!!! Newline!!!!!!!!!!!!====>" + randomWord);
			}
			String newRandomWord = getRandomWord(splitTheLine(choseLineRandomly(a)));
			checked = checkWord(newRandomWord);
			return checked;

		} else {
			// System.out.println("(" + randomWord + ")");
			return randomWord;
		}
	}

	// step6
	String[] generateThreeWords() {
		// create String array of three elements to store the three generated words
		String[] threeWords = new String[3];
		for (int i = 0; i < 3; i++) {
			// step2
			// String randomCHosenLine = choseLineRandomly(a);
			// System.out.println(randomCHosenLine);
			// step3
			// String[] splitArray = splitTheLine(randomCHosenLine);
			// step4
			// String randomWord = getRandomWord(splitArray);
			// step5
			String checkedWord = checkWord(getRandomWord(splitTheLine(choseLineRandomly(a))));
			threeWords[i] = checkedWord;
		}
		//
		String pass = threeWords[0] + threeWords[1] + threeWords[2];
		// System.out.println("[" + pass + "]");
		return threeWords;
	}

	// step 6,check rules a,b,c,d,e
	void checkPasswordRules(String[] passParts) {
		//
		Pattern isUpper = Pattern.compile("^(?=.*[A-Z]).+$");
		Pattern isLower = Pattern.compile("^(?=.*[a-z]).+$");

		Pattern isAlphaNumeric = Pattern.compile("^(?=.*[^a-zA-Z0-9]).+$");

		boolean flag = false;
		// Concatenate the parts
		String pass = passParts[0].toString() + passParts[1].toString() + passParts[2].toString();

		// rule a:
		// No two words can be exactly the same
		if ((passParts[0].compareTo(passParts[1]) == 0) || (passParts[0].compareTo(passParts[1]) == 0)
				|| (passParts[1].compareTo(passParts[2]) == 0)) {
			setEqual();
			// checkPasswordRules(generateThreeWords());
			flag = false;
		}
		// rule b
		// The password must be at least 8 characters long but under 16 characters
		else if ((pass.length() < 8) || (pass.length() >= 16)) {
			// System.out.println("<<<<<" + pass + ">>>>>> deleted LENGTH password");
			setLength();
			// checkPasswordRules(generateThreeWords());
			flag = false;
		}
		// rule c
		else if (!isUpper.matcher(pass).matches())// represent at least one Upper case character.
		{
			// System.out.println("<<<<<" + pass + ">>>>>> deleted UPPER password");
			setUpper();
			// checkPasswordRules(generateThreeWords());
			flag = false;
		}
		// rule d
		else if (!isLower.matcher(pass).matches())// represent at least one lower case character.
		{
			// System.out.println("<<<<<" + pass + ">>>>>> deleted LOWER password");
			setLower();
			// checkPasswordRules(generateThreeWords());
			flag = false;
		}
		// rule e
		else if (!isAlphaNumeric.matcher(pass).matches())// represents at least one special character
		{
			setSpecial();
			// checkPasswordRules(generateThreeWords());
			flag = false;
		} else {
			flag = true;
		}
		//
		if (flag == true)
			setPassword(pass);
		else {
			// System.out.print("<<<<<" + pass + ">>>>>> REGENERATE other one");
			checkPasswordRules(generateThreeWords());
		}
	}

	// show info to check the input text of the password generator program- NOT USED
	static void showInfo(String[][][] a) {
		System.out.println("The number of pages in the text is: " + a.length + " pages.");
		for (int i = 0; i < a.length; i++) {
			System.out.print("     The number of paragraphs  in the page " + i + " is: ");
			System.out.println(a[i].length);
			for (int j = 0; j < a[i].length; j++) {
				System.out.print("     lines  in the paragraph " + i + " is: ");
				System.out.println(a[i][j].length);
			}
		}
	}

}
