package telek;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Falu {
	
	private static int TelekOsszese = 0;
	private static List<Telek> teleklist = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		Scanner scn = new Scanner(new File("resources/telkek.txt"));
		
		String line = scn.nextLine();
		setTelekOsszese(Integer.parseInt(line.trim()));
		
		while(scn.hasNext()) {
			line = scn.nextLine();
			String[] data = line.split(" ");
			getTeleklist().add(
					new Telek(
							Integer.parseInt(data[0]),
							Integer.parseInt(data[1]),
							Integer.parseInt(data[2])
							)
					);
		}
		scn.close();
		
		int sumHossz = 0;
		int keskenyebb = 0;
		Telek max = new Telek(0,0,0);
		Telek min= new Telek(999,999,999);
		int bevetel_g = 0;
		
		for (Telek t : getTeleklist()) {
			sumHossz += t.getHossz();
			
			if(t.getSzeles()<=20 && t.getHossz()==0) {
				keskenyebb++;
			}
			
			if(t.getKaszt().equals("g")) {
				if(t.getTerulet()<min.getTerulet()) {
					min = t;
				}
				if(t.getTerulet()>min.getTerulet()) {
					max = t;
				}
				
				bevetel_g += t.getAdo();
				
			}
		}
		int kerulet = (sumHossz*2)+(80*2);
		
		int koztesTelkek = ((max.getID()-min.getID())-2)/2;
		

		
		System.out.println(getTeleklist().get(0));
		System.out.println("1.feladat: beolvasva");
		System.out.println("2.feladat: "+kerulet);
		System.out.println("3.feladat: "+keskenyebb);
		System.out.printf("4.feladat: %d telek van koztuk, a legkissebb telek : %d, a legnagyobb telek : %d\n",koztesTelkek,min.getID(),max.getID());
		System.out.println("5.feladat: "+ bevetel_g + " Fabatka");
		System.out.println("6.feladat: "+"");
		System.out.println("7.feladat: "+"");
	
	}
	
	public static List<Telek> getTeleklist() {
		return teleklist;
	}

	public static void setTeleklist(List<Telek> teleklist) {
		Falu.teleklist = teleklist;
	}

	public static int getTelekOsszese() {
		return TelekOsszese;
	}

	public static void setTelekOsszese(int telekOsszese) {
		TelekOsszese = telekOsszese;
	}
	
}
