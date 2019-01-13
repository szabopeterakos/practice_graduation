package rejtveny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Megoldas {
	String name;
	boolean isFeladvany = false;
	boolean erintkeznekEgymassal;
	boolean erintikTornyot;
	boolean megfeleloSzamuHajoLatszik;
	int[][] palya = new int[10][10];
	int hajohSzama = 0;
	ArrayList<Integer> szomszedok = new ArrayList<>();

	public void printPalya() {
		// column
		for (int i = 0; i < 10; i++) {
			// row
			for (int j = 0; j < 10; j++) {
				System.out.print(palya[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void readFeladvany(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			String line = null;
			int ii = 0;
			while (null != (line = br.readLine())) {
				int[] fullRow = Arrays.asList(line.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				palya[ii] = fullRow;
				ii++;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean megfeleloToronypoziciok(Megoldas feladvany, Megoldas megoldas) {
		int[][] cfeladvany = feladvany.getPalya();
		int[][] cmegoldas = megoldas.getPalya();

		// row
		for (int i = 0; i < 10; i++) {
			// tagok
			for (int j = 0; j < 10; j++) {
				int actualisFeladvany = cfeladvany[i][j];
				int actualisMegoldas = cmegoldas[i][j];
				if (actualisFeladvany > 0) {
					if (actualisFeladvany != actualisMegoldas) {
						return false;
					}
				}
				if (actualisMegoldas > 0 && actualisMegoldas < 11) {
					if (actualisFeladvany != actualisMegoldas) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public void szamlalHajot() {
		int[][] cmegoldas = getPalya();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int actualisMegoldas = cmegoldas[i][j];
				if (actualisMegoldas == 11) {
					hajohSzama++;
				}
			}
		}
	}

	public void calculateSzomszedok() {
		int[][] cmegoldas = getPalya();
		int max = 10;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int actualisMegoldas = cmegoldas[i][j];
				// jobb
				if (i + 1 < max) {
					szomszedok.add(cmegoldas[i + 1][j]);
				}
				// bal
				if (i - 1 >= 0) {
					szomszedok.add(cmegoldas[i - 1][j]);
				}
				// lent
				if (j + 1 < max) {
					szomszedok.add(cmegoldas[i][j + 1]);
				}
				// fent
				if (j - 1 >= 0) {
					szomszedok.add(cmegoldas[i][j - 1]);
				}
				// jobbfent
				if (i + 1 < max && j - 1 >= 0) {
					szomszedok.add(cmegoldas[i + 1][j - 1]);
				}
				// balfent
				if (i - 1 >= 0 && j - 1 >= 0) {
					szomszedok.add(cmegoldas[i - 1][j - 1]);
				}
				// jobblent
				if (i + 1 < max && j + 1 < max) {
					szomszedok.add(cmegoldas[i + 1][j + 1]);
				}
				// ballent
				if (i - 1 >= 0 && j + 1 < max) {
					szomszedok.add(cmegoldas[i - 1][j + 1]);
				}
			}
		}
	}

	public ArrayList<Integer> getSzomszedok() {
		return szomszedok;
	}

	public int[][] getPalya() {
		return palya;
	}

	public void setPalya(int[][] palya) {
		this.palya = palya;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFeladvany() {
		return isFeladvany;
	}

	public void setFeladvany(boolean isFeladvany) {
		this.isFeladvany = isFeladvany;
	}

	public int getHajoSzama() {
		szamlalHajot();
		return hajohSzama;
	}

}
