package helyjegy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Helyjegy {

	private static int osszesJegy = 0;
	private static int maxUt = 0;
	private static int arPer10km = 71;
	private static List<Utas> utaslista = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(new File("../eladott.txt")));

		String line;
		int lineNumber = 0;
		while ((line = br.readLine()) != null) {
			if (0 == lineNumber) {
				String[] firstLine = line.split(" ");
				if (firstLine.length == 3) {
					setOsszesJegy(Integer.parseInt(firstLine[0]));
					setMaxUt(Integer.parseInt(firstLine[1]));
					setArPer10km(Integer.parseInt(firstLine[2]));
				} else {
					throw new RuntimeException("rossz ertekek mar az elso sorban.");
				}
			} else {
				String[] currentLine = line.split(" ");
				Utas currentUtas = new Utas(lineNumber, currentLine[0], currentLine[1], currentLine[2]);
				utaslista.add(currentUtas);
			}
			lineNumber++;
		}

		Utas utolso = getUtaslista().get(getUtaslista().size() - 1);
		Utas utolsoElott = getUtaslista().get(getUtaslista().size() - 2);
		StringBuilder vegigutazok = new StringBuilder();
		int leSzallok = 0;
		int felSzallok = 0;
		List<Integer> allomasok = new ArrayList<>();
		int kozbeniAllomasok = 0;
		List<Utas> pillanatkep = new ArrayList<>();

		System.out.println("1. feladat [ok] : beolvasva \"eladott.txt\"-t");

		System.out.printf("2. feladat [ok] : id: %d.utas, Tavolsag: %dkm \n", utolso.getUlohely(), utolso.tavolsag());

		int osszBevetel = 0;
		for (int i = 0; i < utaslista.size(); i++) {
			Utas currentUtas = utaslista.get(i);
			osszBevetel = osszBevetel + currentUtas.teljesAr();
			if (currentUtas.getStart() == 0 && currentUtas.getEnd() == maxUt) {
				vegigutazok.append(currentUtas.getID() + " ");
			}
			if (currentUtas.getEnd() == utolsoElott.getEnd()) {
				leSzallok++;
			} else if (currentUtas.getStart() == utolsoElott.getEnd()) {
				felSzallok++;
			}
			if (currentUtas.getStart() != 0 && currentUtas.getStart() != maxUt) {
				if (!allomasok.contains(currentUtas.getStart())) {
					allomasok.add(currentUtas.getStart());
				}
			}
		}

		System.out.println("3. feladat [ok]: " + vegigutazok);
		System.out.println("4. feladat [ok]: " + osszBevetel + "Ft ");

		System.out.println("5. feladat [ok]: leszallo: " + leSzallok+" felszallok: " + felSzallok);

		kozbeniAllomasok = allomasok.size();
		System.out.println("6. feladat : " + kozbeniAllomasok);

		System.out.println("7. feladat [ok] : " + "\"kihol.txt\"-be kiirva");
		int indexKm = 5;
//		System.out.println("Dobj egy idopillanatot jelolo km et es kiirom ki hol ult akkor :) :");
//		Scanner scn = new Scanner(System.in);
//		int indexKm = scn.nextInt();
//		System.out.println(indexKm);

		for (Utas utas : utaslista) {
			if (indexKm >= utas.getStart() && indexKm < utas.getEnd()) {
				pillanatkep.add(utas);
			}
		}

		Collections.sort(pillanatkep, (o1, o2) -> {
			Utas u1 = (Utas) o1;
			Utas u2 = (Utas) o2;
			return u1.getUlohely() - u2.getUlohely();
		});

//		System.out.println(pillanatkep.get(0));
//		System.out.println(pillanatkep.get(pillanatkep.size() - 1));

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("../kihol.txt")));
		for (int i = 1; i <= 48; i++) {
			String cLine = i + ". ules : ";
			String ules = "ures";
			for (Utas utas : pillanatkep) {
				if (utas.getUlohely() == i) {
					ules = "" + utas.getID();
				}
			}
			bw.write(cLine + ules);
			bw.newLine();
		}
		bw.close();

	}

	public static List<Utas> getUtaslista() {
		return utaslista;
	}

	public static void setUtaslista(List<Utas> utaslista) {
		Helyjegy.utaslista = utaslista;
	}

	public static int getOsszesJegy() {
		return osszesJegy;
	}

	public static void setOsszesJegy(int osszesJegy) {
		Helyjegy.osszesJegy = osszesJegy;
	}

	public static int getMaxUt() {
		return maxUt;
	}

	public static void setMaxUt(int maxUt) {
		Helyjegy.maxUt = maxUt;
	}

	public static int getArPer10km() {
		return arPer10km;
	}

	public static void setArPer10km(int arPer10km) {
		Helyjegy.arPer10km = arPer10km;
	}

}
