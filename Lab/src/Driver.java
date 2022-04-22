
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Wellcome to the password generator game!");
		// String.format("%15s",s) // pads left
		int counter = 1;
		for (int i = 0; i < 10000; i++) {

			PasswordGenerator pw = new PasswordGenerator();
			// showInfo(a);

			// System.out.println(pass);
			pw.checkPasswordRules(pw.generateThreeWords());
			System.out.print("Password=");
			System.out.print(String.format("%-16s", pw.getPassword()));

			System.out.println("  NewLine=" + pw.getNewline() + "  Single=" + pw.getSingle() + "  Equal="
					+ pw.getEqual() + "  Length=" + pw.getLength() + "  Upper=" + pw.getUpper() + "  Lower="
					+ pw.getLower() + "  Special=" + pw.getSpecial());
			counter = i + 1;
			if (pw.getLower()>0) {
				break;
			}

		}
		System.out.println("Total Password Genereated=" + counter);
		System.out.println("Thank you for using password generator ");
	}

	public static String fixedLengthString(String string, int length) {
		return String.format("%1$" + length + "s", string);
	}

	public static String stringToFixedLengthString(String value, int length) {
		return String.format("%1" + length + "s", value);
	}
}
