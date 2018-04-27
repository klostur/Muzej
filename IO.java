package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class IO {
	private static String putanja = "slike.txt";
	
	public static void snimiFilmoveUFajl(List<Muzej> muzeji) {
		PrintWriter output = null;
		String unos = Aplikacija.unosMuzeja();
		try {
			output = new PrintWriter(new FileWriter(putanja));
			output.print("Slike u muzeju " + unos + "\n");
			for (Muzej muzej : muzeji) {
				if (muzej.getNaziv().equals(unos)){
					output.println(muzej.prikaziSlike());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (output != null)
				output.close();
		}
	}
	
	
}	
