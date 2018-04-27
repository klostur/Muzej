package test;

import java.util.ArrayList;
import java.util.List;

public class Muzej {
	private String naziv;
	private List<Slika> slike = new ArrayList<>();
	
	public Muzej(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}
	public List<Slika> getSlike() {
		return slike;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String prikaziSlike() {
		StringBuilder sb = new StringBuilder();
		for (Slika slika : slike) {
			sb.append(slika.prikaziSliku() + "\n");
		}
		return sb.toString();
	}
	
}
