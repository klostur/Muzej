package test;
public class Slika {
	private int identifikator;
	private String naslov;
	private int godinaNastanka;
	private Slikar slikar;
	
	static int counter = 0;
	
	public Slika(int identifikator, String naslov, int godinaNastanka, Slikar slikar) {
		super();
		this.identifikator = identifikator;
		this.naslov = naslov;
		this.godinaNastanka = godinaNastanka;
		this.slikar = slikar;
	}

	public int getIdentifikator() {
		return identifikator;
	}

	public String getNaslov() {
		return naslov;
	}

	public int getGodinaNastanka() {
		return godinaNastanka;
	}

	public Slikar getSlikar() {
		return slikar;
	}
	public String prikaziSliku() {
		++counter;
		return counter + ". "+this.naslov + ", " +this.godinaNastanka;
		
	}
	
	
}
