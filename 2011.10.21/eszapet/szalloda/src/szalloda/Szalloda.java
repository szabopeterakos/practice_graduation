package szalloda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Szalloda {

	public static Foglalas maxFoglalo;

	public static void CheckMaxNapokSzama(Foglalas cFoglalo) {
		if (cFoglalo.getId() == 1) {
			maxFoglalo = cFoglalo;
		} else if (cFoglalo.getNapokSzama() > maxFoglalo.getNapokSzama()) {
			maxFoglalo = cFoglalo;
		}
	}

	public static void main(String[] args) {

		List<Foglalas> foglalasok = new ArrayList<>();
		int teljesEviBevetel = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("resources/pitypang.txt")));
			String line = br.readLine();
			while (null != (line = br.readLine())) {
				String[] arr = line.split(" ");

				int id = Integer.parseInt(arr[0]);
				int szobaSzam = Integer.parseInt(arr[1]);
				int erkezes = Integer.parseInt(arr[2]);
				int tavozas = Integer.parseInt(arr[3]);
				int vedegekSzama = Integer.parseInt(arr[4]);
				boolean reggeli = arr[5].equals("0") ? false : true;
				String nev = arr[6];

				Foglalas ff = new Foglalas(id, szobaSzam, erkezes, tavozas, vedegekSzama, reggeli, nev);
				foglalasok.add(ff);

				CheckMaxNapokSzama(ff);

			}
			br.close();

			System.out.println(
					maxFoglalo.getNev() + " (" + maxFoglalo.getErkezes() + ") - " + maxFoglalo.getNapokSzama());

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("resources/bevetel.txt")));
			for (Foglalas foglalas : foglalasok) {
				bw.write(foglalas.getId() + ":" + foglalas.getTeljesar() + "\n");
				teljesEviBevetel += foglalas.getTeljesar();
			}
			bw.flush();
			bw.close();

			System.out.println("A szalloda teljesevi bevetele : " + teljesEviBevetel);

			int aggr1 = 0;
			int aggr2 = 0;
			int aggr3 = 0;
			int aggr4 = 0;
			int aggr5 = 0;
			int aggr6 = 0;
			int aggr7 = 0;
			int aggr8 = 0;
			int aggr9 = 0;
			int aggr10 = 0;
			int aggr11 = 0;
			int aggr12 = 0;

			for (int i = 1; i <= 365; i++) {
				int napiaggreg = 0;
				int nap = i;
				for (Foglalas foglalas : foglalasok) {
					if (nap >= foglalas.getErkezes() && nap < foglalas.getTavozas()) {
						napiaggreg += foglalas.getVedegekSzama();
					}
				}

				if (i >= 1 && i < 32) {
					aggr1 += napiaggreg;
				} else if (i >= 32 && i < 60) {
					aggr2 += napiaggreg;
				} else if (i >= 32 && i < 91) {
					aggr3 += napiaggreg;
				} else if (i >= 32 && i < 121) {
					aggr4 += napiaggreg;
				} else if (i >= 32 && i < 152) {
					aggr5 += napiaggreg;
				} else if (i >= 32 && i < 182) {
					aggr6 += napiaggreg;
				} else if (i >= 32 && i < 213) {
					aggr7 += napiaggreg;
				} else if (i >= 32 && i < 244) {
					aggr8 += napiaggreg;
				} else if (i >= 32 && i < 274) {
					aggr9 += napiaggreg;
				} else if (i >= 32 && i < 305) {
					aggr10 += napiaggreg;
				} else if (i >= 32 && i < 335) {
					aggr11 += napiaggreg;
				} else {
					aggr12 += napiaggreg;
				}
			}

			System.out.printf("1: %d vegedej\n", aggr1);
			System.out.printf("2: %d vegedej\n", aggr2);
			System.out.printf("3: %d vegedej\n", aggr3);
			System.out.printf("4: %d vegedej\n", aggr4);
			System.out.printf("5: %d vegedej\n", aggr5);
			System.out.printf("6: %d vegedej\n", aggr6);
			System.out.printf("7: %d vegedej\n", aggr7);
			System.out.printf("8: %d vegedej\n", aggr8);
			System.out.printf("9: %d vegedej\n", aggr9);
			System.out.printf("10: %d vegedej\n", aggr10);
			System.out.printf("11: %d vegedej\n", aggr11);
			System.out.printf("12: %d vegedej\n", aggr12);

			Scanner scn = new Scanner(System.in);
			System.out.println("start nap / eltoltendo ejszakak pl: 21/5");
			String[] answer = scn.nextLine().split("/");
			scn.close();

			int start = Integer.parseInt(answer[0]);
			int end = start + Integer.parseInt(answer[1]) - 1;
			int[] szobak = new int[27];

			for (int i = start; i <= end; i++) {
				int nap = i;
				for (Foglalas foglalas : foglalasok) {
					if (nap >= foglalas.getErkezes() && nap < foglalas.getTavozas()) {
						szobak[foglalas.getSzobaSzam() - 1]++;
					}
				}
			}

			int szabadSzobak = 0;

			for (int i : szobak) {
				if (i == 0) {
					szabadSzobak++;
				}
			}

			System.out.println("Szabad szobak szama : " + szabadSzobak);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
