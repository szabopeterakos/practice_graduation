package szalloda;

public class Foglalas {

	private int id;
	private int szobaSzam;
	private int erkezes;
	private int tavozas;
	private int vedegekSzama;
	private boolean reggeli;
	private String nev;

	private int teljesar;
	private int napokSzama;

	public Foglalas(int id, int szobaSzam, int erkezes, int tavozas, int vedegekSzama, boolean reggeli, String nev) {
		super();
		this.id = id;
		this.szobaSzam = szobaSzam;
		this.erkezes = erkezes;
		this.tavozas = tavozas;
		this.vedegekSzama = vedegekSzama;
		this.reggeli = reggeli;
		this.nev = nev;

		this.napokSzama = tavozas - erkezes;
		this.teljesar = calculateTeljesAr();
	}

	private int calculateTeljesAr() {
		int szobaAr = Arazas.getSzobaDijaByErkezes(erkezes);
		szobaAr = napokSzama * szobaAr;

		int potagy = (vedegekSzama > 2) ? 2000 : 0;
		potagy = napokSzama * potagy;

		int reggelik = napokSzama * vedegekSzama * Arazas.getREGGELI_DIJA();

		return szobaAr + reggelik + potagy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSzobaSzam() {
		return szobaSzam;
	}

	public void setSzobaSzam(int szobaSzam) {
		this.szobaSzam = szobaSzam;
	}

	public int getErkezes() {
		return erkezes;
	}

	public void setErkezes(int erkezes) {
		this.erkezes = erkezes;
	}

	public int getTavozas() {
		return tavozas;
	}

	public void setTavozas(int tavozas) {
		this.tavozas = tavozas;
	}

	public int getVedegekSzama() {
		return vedegekSzama;
	}

	public void setVedegekSzama(int vedegekSzama) {
		this.vedegekSzama = vedegekSzama;
	}

	public boolean isReggeli() {
		return reggeli;
	}

	public void setReggeli(boolean reggeli) {
		this.reggeli = reggeli;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getTeljesar() {
		return teljesar;
	}

	public void setTeljesar(int teljesar) {
		this.teljesar = teljesar;
	}

	public int getNapokSzama() {
		return napokSzama;
	}

	public void setNapokSzama(int napokSzama) {
		this.napokSzama = napokSzama;
	}
	
	

}
