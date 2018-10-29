package telek;

public class Telek {
	
	private int ID;
	private int szeles;
	private int hossz;
	private String kaszt;
	private int terulet;
	private int ado;
	
	public Telek(int iD, int szeles, int hossz) {
		super();
		ID = iD;
		this.szeles = szeles;
		this.hossz = hossz;
		this.kaszt = hossz == 0 ? "j":"g";
		this.terulet = hossz * szeles;
		setAdo();
	}
	
	public int getAdo() {
		return ado;
	}

	public void setAdo() {
		Double ado = new Double(0);
		
		ado += 700 * 51 ;
		
		if(terulet <= 1000 && terulet > 700) {
			ado += (terulet - 700) * 39;
		}
		if(terulet > 1000) {
			ado += 200;
		}
		
		if(szeles<=15 || 25>=hossz) {
			ado = ado * 0.8;
		}
		
		if(ado<50) {
			ado = 0.0;
		} else if(ado <= 100) {
			ado = 100.0;
		} else {
			String ado_t = ""+ado.intValue();
			String adoVege = ado_t.substring(ado_t.length()-2);
			String adoEleje = ado_t.substring(0,ado_t.length()-2);
			
			double v = Integer.parseInt(adoVege);
			double e = Integer.parseInt(adoEleje);
			if(v <= 50) {
				ado = e * 100;
			} else {
				ado = e * 100 + 100;
			}
		}
		
		this.ado = ado.intValue();
	}

	public String getKaszt() {
		return kaszt;
	}

	public void setKaszt(String kaszt) {
		this.kaszt = kaszt;
	}

	public int getTerulet() {
		return terulet;
	}

	public void setTerulet(int terulet) {
		this.terulet = terulet;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getSzeles() {
		return szeles;
	}
	
	public void setSzeles(int szeles) {
		this.szeles = szeles;
	}
	
	public int getHossz() {
		return hossz;
	}
	
	public void setHossz(int hossz) {
		this.hossz = hossz;
	}

	@Override
	public String toString() {
		return "Telek [ID=" + ID + ", szeles=" + szeles + ", hossz=" + hossz + ", kaszt=" + kaszt + ", terulet="
				+ terulet + ", ado=" + ado + "]";
	}
	
}
