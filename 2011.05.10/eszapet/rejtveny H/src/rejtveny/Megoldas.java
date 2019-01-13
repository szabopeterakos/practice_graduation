package rejtveny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Megoldas {
	String name;
	boolean isFeladvany = false;
	boolean erintkeznekEgymassal;
	boolean erintikTornyot;
	boolean megfeleloSzamuHajoLatszik;
	int[][] palya = new int[10][10];
	int hajohSzama = 0;

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

	public boolean megeleloToronypoziciok(Megoldas feladvany, Megoldas megoldas) {
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

	public void szamlalSzomszedot() {
		int[][] cmegoldas = getPalya();

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int actualisMegoldas = cmegoldas[i][j];
				if (actualisMegoldas == 11) {
					int szomszed1 = cmegoldas[i][j + 1];
					int szomszed2 = cmegoldas[i][j - 1];

					int szomszed3 = cmegoldas[i + 1][j + 1];
					int szomszed4 = cmegoldas[i - 1][j + 1];

					int szomszed5 = cmegoldas[i + 1][j - 1];
					int szomszed6 = cmegoldas[i - 1][j - 1];

					int szomszed7 = cmegoldas[i + 1][j];
					int szomszed8 = cmegoldas[i - 1][j];
					if (szomszed1 != 0 || szomszed2 != 0 || szomszed3 != 0 || szomszed4 != 0 || szomszed5 != 0
							|| szomszed6 != 0 || szomszed7 != 0 || szomszed8 != 0) {
//						return false;
					}
				}
			}
		}
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

	public int getHajohSzama() {
		szamlalHajot();
		return hajohSzama;
	}

}
