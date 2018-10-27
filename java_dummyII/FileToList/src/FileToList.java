import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileToList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("./src/eladott.txt"));

			ArrayList<String> hole_text = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				hole_text.add(line);
			}

			int index = 0;
			while (index < hole_text.size() - 1) {
				System.out.println(hole_text.get(index++));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
