package helyjegy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utas {

	private int ID;
	private int ulohely;
	private int start;
	private int end;

	public Utas(int ID, String ulohely, String start, String end) {
		super();
		this.ID = ID;
		this.ulohely = Integer.parseInt(ulohely);
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
	}

	public int tavolsag() {
		return end - start;
	}

	public int teljesAr() {
		int megkezdettKm = (tavolsag() % 10) != 0 ? (tavolsag() / 10) + 1 : tavolsag() / 10;
		int ar = megkezdettKm * Helyjegy.getArPer10km();
		int lastDigit = ar % 10;
		if (lastDigit != 0 || lastDigit != 5) {
			switch (lastDigit) {
			case 1:
			case 2:
				ar = ar - lastDigit;
				break;
			case 3:
			case 4:
				ar = ar + (5 - lastDigit);
				break;
			case 6:
			case 7:
				ar = ar - (lastDigit - 5);
				break;
			case 8:
			case 9:
				ar = ar + (10 - lastDigit);
				break;
			}
		}
		return ar;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getUlohely() {
		return ulohely;
	}

	public void setUlohely(int ulohely) {
		this.ulohely = ulohely;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Utas [ID=" + ID + ", ulohely=" + ulohely + ", start=" + start + ", end=" + end + ", tavolsag()="
				+ tavolsag() + ", teljesAr()=" + teljesAr() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ulohely;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utas other = (Utas) obj;
		if (ulohely != other.ulohely)
			return false;
		return true;
	}

}
