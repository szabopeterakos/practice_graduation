package szavak;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Szavak {

	public static void main(String[] args) throws Exception {
		char[] maganhangzok = { 'a', 'e', 'i', 'o', 'u' };

		System.out.println("1. FELADAT");
		Scanner sc = new Scanner(System.in);
		System.out.println("Adjon meg egy szót: ");
		String aWord = sc.nextLine();

		boolean hasMaganhangzot = false;

		for (char c : maganhangzok) {
			if (aWord.contains(String.valueOf(c))) {
				hasMaganhangzot = true;
				break;
			}
		}

		System.out.println(hasMaganhangzot ? "Van benne magánhangzó." : "Nincs benne magánhangzó.");

		System.out.println("2. FELADAT");
		BufferedReader br = new BufferedReader(new FileReader(new File("resources/szoveg.txt")));
		String line = null;
		String maxLengthWord = "";
		while (null != (line = br.readLine())) {
			line = line.trim();
			if (line.length() > maxLengthWord.length()) {
				maxLengthWord = line;
			}
		}
		br.close();
		System.out.printf("A szovegben a leghosszabb szo : %s, ami %d karakterbol all."
				+ "(tobb szo eseteben az utolso jelenik meg)\n", maxLengthWord, maxLengthWord.length());

		System.out.println("3. FELADAT");
		int osszesSzo = 0;
		int maganTobbOsszesen = 0;
		br = new BufferedReader(new FileReader(new File("resources/szoveg.txt")));
		line = null;
		while (null != (line = br.readLine())) {
			line = line.trim();
			osszesSzo++;
			int cMagan = 0;
			int cMassal = 0;
			for (char c : line.toCharArray()) {
				for (char m : maganhangzok) {
					if (c == m) {
						cMagan++;
					}
				}
			}
			if (cMagan > (line.length() - cMagan)) {
				maganTobbOsszesen++;
				System.out.print(line + " ");
			}
		}
		br.close();
		System.out.println();
		System.out.printf("%d/%d : %.2f", maganTobbOsszesen, osszesSzo, ((double) maganTobbOsszesen) / osszesSzo);
		System.out.print("%\n");

		System.out.println("4. FELADAT");
		List<String> otCaracteresSzavak = new ArrayList<>(1000);
		br = new BufferedReader(new FileReader(new File("resources/szoveg.txt")));
		line = null;
		while (null != (line = br.readLine())) {
			line = line.trim();
			if (line.length() == 5) {
				otCaracteresSzavak.add(line);
			}
		}
		br.close();

		System.out.println("Adjon meg egy 3 karakteres szót: ");
		aWord = sc.nextLine();
		boolean bFlag = true;
		for (String szo : otCaracteresSzavak) {
			if (szo.substring(1, 4).equals(aWord)) {
				bFlag = false;
				System.out.print(szo + " ");
			}
		}
		if(bFlag) {
			System.out.print("Nincs ehhez passzolo letraszo az adatbazisban. :(");
		}
		System.out.println();

		System.out.println("5. FELADAT");
		List<ArrayList<String>> list = new ArrayList<>();
		List<String> letraSzavak = new ArrayList<>();
		for (int i = 0; i < otCaracteresSzavak.size(); i++) {
			String vizsgalt = otCaracteresSzavak.get(i);
			String vReszlet = vizsgalt.substring(1, 4);
			if(!letraSzavak.contains(vReszlet)) {
				letraSzavak.add(vReszlet);
			}
		}
		for (String letra : letraSzavak) {
			ArrayList<String> egyLetrahoztartozSzavak = new ArrayList<>();
			for (int i = 0; i < otCaracteresSzavak.size(); i++) {
				String vizsgalt = otCaracteresSzavak.get(i);
				String vReszlet = vizsgalt.substring(1, 4);
				if(letra.equals(vReszlet)) {
					egyLetrahoztartozSzavak.add(vizsgalt);
				}
			}
			list.add(egyLetrahoztartozSzavak);
		}
		sc.close();
		
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("resources/letra.txt")));
		for (ArrayList<String> egyLetrahoztartozSzavak : list) {
			if(egyLetrahoztartozSzavak.size()>1){
				for (String szo : egyLetrahoztartozSzavak) {
					bw.write(szo+"\n");
				}
				bw.write("\n");
			}
		}
		bw.close();
		System.out.println("Kiirva, koszonom a figyelmet :)");
		
		

	}

}
