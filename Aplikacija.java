package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Aplikacija {
	static List<Muzej> muzeji = new ArrayList<>();
	static List<Slikar> slikari = new ArrayList<>();

	public static void main(String[] args) {

		muzeji.add(new Muzej("Narodni muzej"));
		muzeji.add(new Muzej("Muzej partizana"));
		muzeji.add(new Muzej("Luvr"));
		
		slikari.add(new Slikar("Sava", "Sumanovic"));
		slikari.add(new Slikar("Ibra", "Slavkovic"));
		slikari.add(new Slikar("Kiko", "Belementa"));
		slikari.add(new Slikar("Milutin", "Milankovic"));
		
		
		muzeji.get(1).getSlike().add(new Slika(1, "Devojka na livadi", 1935, slikari.get(0)));
		muzeji.get(0).getSlike().add(new Slika(2, "Konj u jezeru", 1934, slikari.get(1)));
		muzeji.get(0).getSlike().add(new Slika(2, "Zora u predgradju", 1936, slikari.get(2)));
		muzeji.get(1).getSlike().add(new Slika(3, "Pehar i jabuke", 1936, slikari.get(2)));
		muzeji.get(0).getSlike().add(new Slika(3, "Motori", 1938, slikari.get(3)));
		muzeji.get(1).getSlike().add(new Slika(3, "Kako je propao RnR", 1936, slikari.get(0)));
		muzeji.get(1).getSlike().add(new Slika(3, "Mona", 1936, slikari.get(0)));
		muzeji.get(0).getSlike().add(new Slika(3, "Traktori", 1931, slikari.get(0)));
		
		
		String input = "";
		do {
			meni();
			input = unesi();
			switch (input) {
			case "1":
				prikaziSlike();
				break;
			case "2":
				IO.snimiFilmoveUFajl(muzeji);
				break;
			case "3":
				najzastupljenijiSlikar();
				break;
			case "4":
				muzejNajviseSlikaPeriod();
				break;
			default:
				break;
			}
			
		} while (!input.equals("q"));
		
		
	}
	
	private static void muzejNajviseSlikaPeriod() {
		//unos podataka za slikara
		System.out.println("Upisite ime slikara");
		String ime = unesi();
		System.out.println("Upisite prezime slikara");
		String prezime = unesi();
		System.out.println("Upisite pocetni period");
		int pocetak = Integer.parseInt(unesi());
		System.out.println("Upisite krajnji period");
		int kraj = Integer.parseInt(unesi());
		pronadjiMuzej(ime, prezime, pocetak, kraj);
		
	}

	private static void pronadjiMuzej(String ime, String prezime, int pocetak, int kraj) {
		int [] niz = new int [muzeji.size()];
		for (int i = 0; i < muzeji.size(); i++) {
			for (int j = 0; j < muzeji.get(i).getSlike().size(); j++) {
				
				Slika slika = muzeji.get(i).getSlike().get(j);
				if (slika.getSlikar().getIme().equals(ime) && 
						slika.getSlikar().getPrezime().equals(prezime) &&
						slika.getGodinaNastanka() > pocetak && 
						slika.getGodinaNastanka() < kraj) {
					niz[i] = + 1;
				}
			}
		}
		int maks = 0;
		for (int i = 0; i < niz.length; i++) {
			if (maks < niz[i]) {
				maks = i;
			}
		}
		System.out.println(muzeji.get(maks).getNaziv() + " ima najvise slika autora " + ime + " " + prezime + " od " +
		pocetak + " do " + kraj + ".");
	}

	private static void najzastupljenijiSlikar() {
		//broji koliko se puta koji slikar pojavljuje u i zapisuje koliko se ko puta pojavio u int niz
		int [] niz = new int[slikari.size()];
		for (int i = 0; i < slikari.size(); i++) {
			for (int j = 0; j < sviSlikari().size(); j++) {
				if (slikari.get(i) == sviSlikari().get(j)){
					niz[i] += 1;
				}
			}
		}
		//maks je lokacija slikara sa najvise slika
		int maks = 0;
		for (int i = 0; i < niz.length; i++) {
			if (maks < niz[i]) {
				maks = i;
			}
		}
		System.out.println(slikari.get(maks).getIme() + " " + slikari.get(maks).getPrezime());
	}
	
	private static ArrayList<Slikar> sviSlikari() {
		//lista kroz slike i popisuje autore na gomilu, pa koji se najvise pojavljuje taj je najjaci
		ArrayList<Slikar> slikari = new ArrayList<>();
		for (int i = 0; i < muzeji.size(); i++) {
			for (int j = 0; j < muzeji.get(i).getSlike().size(); j++) {
				slikari.add(muzeji.get(i).getSlike().get(j).getSlikar());
			}
		}
		return slikari;
	}
	private static void prikaziSlike() {
		for (Muzej muzej : muzeji) {
			System.out.print(muzej.prikaziSlike());
		}
	}
	public static String unosMuzeja() {
		System.out.println("Upisite ime muzeja:");
		for (Muzej muzej : muzeji) {
			System.out.println(muzej.getNaziv());
		}
		String unosMuzeja = unesi();
		return unosMuzeja;
	}
	
	
	private static String unesi() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	private static void meni() {
		System.out.println("---------------------------------");
		System.out.println("Evidencija umetnickih dela Srbije");
		System.out.println("1) Prikaz svih slika");
		System.out.println("2) Snimanje u fajl");
		System.out.println("3) Najzastupljeniji slikar");
		System.out.println("4) Muzej sa najvise slika za period");
		System.out.println("q) Kraj");
	}
}
