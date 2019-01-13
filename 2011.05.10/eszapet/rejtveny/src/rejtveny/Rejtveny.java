package rejtveny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Rejtveny {

	public static void main(String[] args) {
		Megoldas m = new Megoldas();

		System.out.println("1. Feladat");
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Adja meg a torony adatait!\npl:(2,4,5) jelentese 2.sor, 4.oszlop-ban alljon a torony, 5 torony lahtato onnan.\n");
		String answerString = sc.nextLine();
		String[] answers = answerString.split(",");
		if (Integer.valueOf(answers[2]) > 3) {
			System.out.println("Nehéz torony.");
		}

		System.out.println("2. Feladat");
		int[][] palya = m.getPalya();
		palya = new int[4][4];
		int userRow = Integer.valueOf(answers[0]) - 1;
		int userColumn = Integer.valueOf(answers[1]) - 1;
		int userTornyotLat = Integer.valueOf(answers[2]);

		// column
		for (int i = 0; i < palya.length; i++) {
			// row
			for (int j = 0; j < palya[0].length; j++) {
				int mostRow = i;
				int mostColumn = j;

				if (mostRow != userRow && mostColumn != userColumn) {
					int kiirtRow = mostRow + 1;
					int kiirtColumn = mostColumn + 1;
					System.out.println(kiirtRow + "," + kiirtColumn);
				}

			}
		}

		System.out.println("3. Feladat");
		m.readFeladvany("resources/feladvany.txt");
		ArrayList<Megoldas> megoldasok = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("resources/megoldas.txt")));
			String line = null;
			int ii = 0;
			int[] intarr = Arrays.asList(br.readLine().trim()).stream().mapToInt(Integer::parseInt).toArray();
			int bekuldottMegoldasok = intarr[0];
			ii++;
			while (null != (line = br.readLine())) {
				// read name
				String bekuldoNeve = line;

				// create table
				Megoldas cMegoldas = new Megoldas();
				int[][] cPalya = new int[10][10];
				for (int i = 0; i < 10; i++) {
					line = br.readLine();
					int[] fullRow = Arrays.asList(line.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
					cPalya[i] = fullRow;
				}
				cMegoldas.setPalya(cPalya);
				cMegoldas.setName(bekuldoNeve);
				megoldasok.add(cMegoldas);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// torony lokacio osszehasonlitas
		Megoldas feladvany = new Megoldas();
		feladvany.readFeladvany("resources/feladvany.txt");
		feladvany.setFeladvany(true);

		int perhapsSolution = 0;
		ArrayList<Megoldas> szurtMegoldasok = new ArrayList<>(); // erre a feladatra erkezett megoldasok
		for (Megoldas cM : megoldasok) {
			if (!feladvany.megfeleloToronypoziciok(feladvany, cM)) {
				System.out.println(cM.getName());
			} else {
				szurtMegoldasok.add(cM);
				perhapsSolution++;
			}
		}
		if (perhapsSolution == 0) {
			System.out.println("Mindegyik megoldás erre a heti feladványra érkezett.");
		}

		System.out.println("4. Feladat");
		int rosszHajok = 0;
		for (Megoldas megoldas : szurtMegoldasok) {
			if (megoldas.getHajoSzama() != 12) {
				rosszHajok++;
			}
		}
		System.out.printf("%d darab rosszmegoldas volt (hajok szama nem stimmelt)\n",rosszHajok);

		System.out.println("5. Feladat");
		int rosszHajokII = 0;
		for (Megoldas megoldas : szurtMegoldasok) {
			if (megoldas.getHajoSzama() > 12) {
				megoldas.calculateSzomszedok();
			}
		}
		
		System.out.printf("%d darab rosszmegoldas volt (hajok szama stimmelt de a szomszedkapcsolatok szarok)\n",rosszHajokII);
		
		System.out.println("6. Feladat");
	}

}
