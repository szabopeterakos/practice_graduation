package fromStdIn;

import java.util.Scanner;

public class FromStdIn {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Press something to continue . . .\n ");
		String line = scan.nextLine();
		System.out.println("your line is : ");
		System.out.println(line);

	}

}
