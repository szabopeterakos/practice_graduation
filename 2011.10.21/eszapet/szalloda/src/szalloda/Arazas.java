package szalloda;

public class Arazas {

	private static int POTAGY_DIJA = 2000;
	private static int REGGELI_DIJA = 1100;
	private static int SZOBA_TAVASZI_DIJA = 9000;
	private static int SZOBA_NYARI_DIJA = 10000;
	private static int SZOBA_OSZI_DIJA = 8000;

	public static int getPOTAGY_DIJA() {
		return POTAGY_DIJA;
	}

	public static int getREGGELI_DIJA() {
		return REGGELI_DIJA;
	}

	public static int getSzobaDijaByErkezes(int erkezes) {
		int e = erkezes;
		if (e >= 1 && e < 121) {
			return SZOBA_TAVASZI_DIJA;
		} else if (e >= 121 && e < 244) {
			return SZOBA_NYARI_DIJA;
		} else {
			return SZOBA_OSZI_DIJA;
		}
	}

}
