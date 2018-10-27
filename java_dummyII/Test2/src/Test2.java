import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static String id = "[TEST PROGRAM] ";

	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println(id+"not have a parameter but needed");
			return;
		}

		// TODO Auto-generated method stub
		System.out.println(id + "\nSTART");

		System.err.println(id + "This value is : " + args[0]);

		System.out.println("\n" + id + "END");

		BufferedWriter br;

		try {
			br = new BufferedWriter(new FileWriter(new File("tester.ctc")));
			br.write(args[0]);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
